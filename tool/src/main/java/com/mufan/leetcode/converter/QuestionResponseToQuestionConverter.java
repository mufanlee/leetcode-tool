package com.mufan.leetcode.converter;

import com.mufan.leetcode.enums.Difficulty;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.model.response.QuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * QuestionResponse To Question Converter
 *
 * @author lipeng
 */
@Mapper(imports = {Difficulty.class})
public interface QuestionResponseToQuestionConverter extends Converter<QuestionResponse.Data.Question, Question> {
    QuestionResponseToQuestionConverter INSTANCE = Mappers.getMapper(QuestionResponseToQuestionConverter.class);

    @Mapping(target = "difficulty", expression = "java(Difficulty.getEnum(source.getDifficulty()))")
    @Override
    Question convert(QuestionResponse.Data.Question source);
}