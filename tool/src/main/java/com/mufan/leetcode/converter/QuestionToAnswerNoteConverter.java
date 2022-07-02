package com.mufan.leetcode.converter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.text.CharSequenceUtil;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.model.AnswerNote;
import com.mufan.leetcode.model.CodeSnippet;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.MessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Question To AnswerNote Converter
 *
 * @author lipeng
 */
@Mapper(builder = @Builder(disableBuilder = true))
public abstract class QuestionToAnswerNoteConverter implements Converter<Question, AnswerNote> {
    public static final QuestionToAnswerNoteConverter INSTANCE =
            Mappers.getMapper(QuestionToAnswerNoteConverter.class);

    private static final String BASE_NAME = "locales.messages";

    @Mapping(target = "id", source = "questionFrontendId")
    @Mapping(target = "title", source = "translatedTitle")
    @Mapping(target = "slug", source = "titleSlug")
    @Mapping(target = "question", ignore = true)
    @Mapping(target = "difficulty", ignore = true)
    @Mapping(target = "codes", ignore = true)
    @Override
    public abstract AnswerNote convert(Question source);

    @AfterMapping
    protected void afterConvert(Question source, @MappingTarget AnswerNote target) {
        String difficulty = MessageUtils.getMessage(BASE_NAME, "difficulty." + source.getDifficulty().getName());
        target.setDifficulty(difficulty);
        target.setQuestion(HtmlToMdConverter.INSTANCE.convert(source.getTranslatedContent()));
        List<Pair<String, String>> codes = Arrays.stream(CodeLang.values())
                .filter(lang -> lang != CodeLang.UNKNOWN)
                .map(lang ->
                        Pair.of(lang.getValue(), Optional.ofNullable(source.getCodeSnippets())
                                .filter(CollectionUtil::isNotEmpty)
                                .flatMap(snippets -> snippets.stream()
                                        .filter(snippet -> CharSequenceUtil.equalsIgnoreCase(
                                                snippet.getLangSlug(), lang.getSlug()))
                                        .findFirst())
                                .map(CodeSnippet::getCode)
                                .orElse(StringUtils.EMPTY)))
                .collect(Collectors.toList());
        target.setCodes(codes);
    }
}
