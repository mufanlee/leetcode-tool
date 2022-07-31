package com.mufan.leetcode.converter;

import com.mufan.leetcode.model.ContestRank;
import com.mufan.leetcode.model.response.RankResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * RankResponse To ContestRank Converter
 *
 * @author lipeng
 */
@Mapper
public interface RankResponseToContestRankConverter extends Converter<RankResponse, ContestRank> {
    RankResponseToContestRankConverter INSTANCE = Mappers.getMapper(RankResponseToContestRankConverter.class);

    @Override
    ContestRank convert(RankResponse source);
}
