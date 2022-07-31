package com.mufan.leetcode.helper;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.mufan.leetcode.constant.LeetCodeConstants;
import com.mufan.leetcode.converter.RankResponseToContestRankConverter;
import com.mufan.leetcode.converter.WeeklyContestResponseToWeeklyContestConverter;
import com.mufan.leetcode.enums.Region;
import com.mufan.leetcode.model.ContestRank;
import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.model.response.RankResponse;
import com.mufan.leetcode.model.response.WeeklyContestResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * LeetCode Weekly Contest Helper
 *
 * @author lipeng
 */
public class LeetCodeWeeklyContestHelper {
    private static final Log LOG = Log.get();

    private LeetCodeWeeklyContestHelper() {
    }

    public static Optional<WeeklyContest> getWeeklyContest(int id) {
        return getWeeklyContest(LeetCodeConstants.WEEKLY_CONTEST_URL, id);
    }

    public static Optional<WeeklyContest> getBiweeklyContest(int id) {
        return getWeeklyContest(LeetCodeConstants.BIWEEKLY_CONTEST_URL, id);
    }

    public static Optional<ContestRank> getRanking(int id, Region region) {
        Optional<ContestRank> rankOptional = getRanking(LeetCodeConstants.WEEKLY_CONTEST_RANK_URL, id, 1, region);
        if (!rankOptional.isPresent()) {
            return rankOptional;
        }

        ContestRank contestRank = rankOptional.get();
        int userNum = contestRank.getUserNum();
        if (contestRank.getTotalRank().size() >= userNum) {
            return rankOptional;
        }

        int pageSize = contestRank.getTotalRank().size();
        int totalPagination = (userNum + pageSize - 1) / pageSize;
        LOG.info("总共：" + totalPagination + "页，每页 " + pageSize + " 条。");
        for (int i = 2; i <= totalPagination; i++) {
            getRanking(LeetCodeConstants.WEEKLY_CONTEST_RANK_URL, id, i, region)
                    .ifPresent(rank -> contestRank.getTotalRank().addAll(rank.getTotalRank()));
        }
        return rankOptional;
    }

    private static Optional<WeeklyContest> getWeeklyContest(String url, int id) {
        HttpResponse response = HttpRequest.get(StrUtil.format(url, MapUtil.of("id", id)))
                .header(Header.ACCEPT, ContentType.JSON.getValue())
                .timeout(LeetCodeConstants.TIMEOUT)
                .execute();
        return Optional.of(response)
                .filter(HttpResponse::isOk)
                .map(HttpResponse::body)
                .map(it -> JSONUtil.toBean(it, WeeklyContestResponse.class))
                .map(WeeklyContestResponseToWeeklyContestConverter.INSTANCE::convert);
    }

    private static Optional<ContestRank> getRanking(String url, int id, int pagination, Region region) {
        Map<String, Object> build = MapUtil.builder(new HashMap<String, Object>(2))
                .put("region", region.getValue())
                .put("pagination", pagination)
                .build();
        HttpResponse response = HttpRequest.get(StrUtil.format(url, MapUtil.of("id", id)))
                .header(Header.ACCEPT, ContentType.JSON.getValue())
                .form(build)
                .timeout(LeetCodeConstants.TIMEOUT)
                .execute();
        return Optional.of(response)
                .filter(HttpResponse::isOk)
                .map(HttpResponse::body)
                .map(it -> JSONUtil.toBean(it, RankResponse.class))
                .map(RankResponseToContestRankConverter.INSTANCE::convert);
    }
}
