package com.mufan.leetcode.helper;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.mufan.leetcode.constant.LeetCodeConstants;
import com.mufan.leetcode.converter.WeeklyContestResponseToWeeklyContestConverter;
import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.model.response.WeeklyContestResponse;

import java.util.Optional;

/**
 * LeetCode Weekly Contest Helper
 *
 * @author lipeng
 */
public class LeetCodeWeeklyContestHelper {
    private LeetCodeWeeklyContestHelper() {
    }

    public static Optional<WeeklyContest> getWeeklyContest(int id) {
        HttpResponse response = HttpRequest.get(StrUtil.format(LeetCodeConstants.WEEKLY_CONTEST_URL, MapUtil.of("id", id)))
                .header(Header.ACCEPT, ContentType.JSON.getValue())
                .timeout(LeetCodeConstants.TIMEOUT)
                .execute();
        return Optional.of(response)
                .filter(HttpResponse::isOk)
                .map(HttpResponse::body)
                .map(it -> JSONUtil.toBean(it, WeeklyContestResponse.class))
                .map(WeeklyContestResponseToWeeklyContestConverter.INSTANCE::convert);
    }
}
