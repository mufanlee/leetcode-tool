package com.mufan.leetcode.helper;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.TemplateUtils;

import java.util.Optional;

/**
 * Leetcode Question Helper
 *
 * @author lipeng
 */
public final class LeetCodeQuestionHelper {
    private LeetCodeQuestionHelper() {
    }

    private static final String GET_STG = "templates/leetcode/question-request-body.stg";
    public static final String GET_NAME = "questionRequestBodyTemplate";

    public static Optional<Question> getQuestion(String questionSlug) {
        HttpResponse response =
                HttpRequest.post("https://leetcode.cn/graphql/")
                        .header(Header.ACCEPT, ContentType.JSON.getValue())
                        .body(TemplateUtils.render(GET_STG, GET_NAME, "questionSlug", questionSlug))
                        .timeout(90000)
                        .execute();
        return Optional.of(response)
                .filter(HttpResponse::isOk)
                .map(HttpResponse::body)
                .map(JSONObject::parseObject)
                .map(jsonObject -> jsonObject.getJSONObject("data"))
                .map(jsonObject -> jsonObject.getJSONObject("question"))
                .map(jsonObject -> JSONUtil.toBean(jsonObject.toJSONString(), Question.class));
    }
}
