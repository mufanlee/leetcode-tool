package com.mufan.leetcode.converter;

import com.mufan.leetcode.enums.Difficulty;
import com.mufan.leetcode.model.DailyQuestion;
import com.mufan.leetcode.model.response.DailyQuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DailyQuestionResponse To DailyQuestion Converter
 *
 * @author lipeng
 */
@Mapper(imports = {Difficulty.class})
public interface DailyQuestionResponseToDailyQuestionConverter
        extends Converter<DailyQuestionResponse.Data.TodayRecord.Question, DailyQuestion> {
    DailyQuestionResponseToDailyQuestionConverter INSTANCE
            = Mappers.getMapper(DailyQuestionResponseToDailyQuestionConverter.class);

    @Mapping(target = "difficulty", expression = "java(Difficulty.getEnum(source.getDifficulty()))")
    @Override
    DailyQuestion convert(DailyQuestionResponse.Data.TodayRecord.Question source);
}
