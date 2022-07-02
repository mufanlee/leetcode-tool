package com.mufan.leetcode.helper;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.mufan.leetcode.constant.LeetCodeConstants;
import com.mufan.leetcode.converter.QuestionResponseToQuestionConverter;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.model.response.QuestionResponse;
import com.mufan.leetcode.util.TemplateUtils;

import java.util.Optional;

/**
 * LeetCode Question Helper
 *
 * @author lipeng
 */
public final class LeetCodeQuestionHelper {
    private static final String GET_STG = "templates/leetcode/question-request-body.stg";
    public static final String GET_NAME = "questionRequestBodyTemplate";

    private LeetCodeQuestionHelper() {
    }

    public static Optional<Question> getQuestion(String questionSlug) {
        HttpResponse response =
                HttpRequest.post(LeetCodeConstants.GRAPH_QL_URL)
                        .header(Header.ACCEPT, ContentType.JSON.getValue())
                        .body(TemplateUtils.render(GET_STG, GET_NAME, "questionSlug", questionSlug))
                        .timeout(LeetCodeConstants.TIMEOUT)
                        .execute();
        return Optional.of(response)
                .filter(HttpResponse::isOk)
                .map(HttpResponse::body)
                .map(it -> JSONUtil.toBean(it, QuestionResponse.class))
                .map(QuestionResponse::getData)
                .map(QuestionResponse.Data::getQuestion)
                .map(QuestionResponseToQuestionConverter.INSTANCE::convert);
    }
}
