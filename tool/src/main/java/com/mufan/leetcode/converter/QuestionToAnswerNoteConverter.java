package com.mufan.leetcode.converter;

import cn.hutool.core.collection.CollectionUtil;
import com.mufan.leetcode.model.CodeSnippet;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.model.AnswerNote;
import com.mufan.leetcode.model.Question;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/**
 * @author lipeng
 */
@Mapper(builder = @Builder(disableBuilder = true))
public abstract class QuestionToAnswerNoteConverter implements Converter<Question, AnswerNote> {
  public static final QuestionToAnswerNoteConverter INSTANCE =
      Mappers.getMapper(QuestionToAnswerNoteConverter.class);

  @Mapping(target = "id", source = "questionFrontendId")
  @Mapping(target = "title", source = "translatedTitle")
  @Mapping(target = "slug", source = "titleSlug")
  @Mapping(target = "question", ignore = true)
  @Mapping(target = "lang", ignore = true)
  @Mapping(target = "code", ignore = true)
  @Override
  public abstract AnswerNote convert(Question source);

  @AfterMapping
  public void afterConvert(Question source, @MappingTarget AnswerNote target) {
    target.setQuestion(MdConverter.convert(source.getTranslatedContent()));
    CodeLang lang = CodeLang.JAVA;
    target.setLang(lang.getValue());
    String code =
        Optional.ofNullable(source.getCodeSnippets())
            .filter(CollectionUtil::isNotEmpty)
            .flatMap(
                codeSnippets ->
                    codeSnippets.stream()
                        .filter(snippet -> snippet.getLang().equals(lang.getValue()))
                        .findFirst())
            .map(CodeSnippet::getCode)
            .orElse(StringUtils.EMPTY);
    target.setCode(code);
  }
}
