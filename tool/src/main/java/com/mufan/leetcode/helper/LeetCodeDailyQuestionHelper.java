package com.mufan.leetcode.helper;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.mufan.leetcode.constant.LeetCodeConstants;
import com.mufan.leetcode.converter.DailyQuestionResponseToDailyQuestionConverter;
import com.mufan.leetcode.model.DailyQuestion;
import com.mufan.leetcode.model.response.DailyQuestionResponse;
import com.mufan.leetcode.util.TemplateUtils;

import java.util.Collections;
import java.util.Optional;

/**
 * LeetCode Daily Question Helper
 *
 * @author lipeng
 */
public final class LeetCodeDailyQuestionHelper {
    private static final String GET_REQUEST_BODY_STG = "templates/leetcode/daily-question-request-body.stg";
    public static final String GET_NAME = "dailyQuestionRequestBodyTemplate";

    private LeetCodeDailyQuestionHelper() {
    }

    public static Optional<DailyQuestion> getDailyQuestion() {
        HttpResponse response = HttpRequest.post(LeetCodeConstants.GRAPH_QL_URL)
                .header(Header.ACCEPT, ContentType.JSON.getValue())
                .body(TemplateUtils.render(GET_REQUEST_BODY_STG, GET_NAME, Collections.emptyMap()))
                .timeout(LeetCodeConstants.TIMEOUT)
                .execute();
        return Optional.of(response)
                .filter(HttpResponse::isOk)
                .map(HttpResponse::body)
                .map(it -> JSONUtil.toBean(it, DailyQuestionResponse.class))
                .map(DailyQuestionResponse::getData)
                .map(DailyQuestionResponse.Data::getTodayRecord)
                .map(CollectionUtil::getFirst)
                .map(DailyQuestionResponse.Data.TodayRecord::getQuestion)
                .map(DailyQuestionResponseToDailyQuestionConverter.INSTANCE::convert);
    }
}
