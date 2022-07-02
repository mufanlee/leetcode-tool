package com.mufan.leetcode.converter;

import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.model.response.WeeklyContestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * WeeklyContestResponse To WeeklyContest Converter
 *
 * @author lipeng
 */
@Mapper
public interface WeeklyContestResponseToWeeklyContestConverter extends Converter<WeeklyContestResponse, WeeklyContest> {
    WeeklyContestResponseToWeeklyContestConverter INSTANCE
            = Mappers.getMapper(WeeklyContestResponseToWeeklyContestConverter.class);

    @Override
    WeeklyContest convert(WeeklyContestResponse source);
}
