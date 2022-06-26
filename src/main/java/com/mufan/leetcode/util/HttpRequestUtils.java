package com.mufan.leetcode.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.mufan.leetcode.model.MyHttpRequest;
import com.mufan.leetcode.model.MyHttpResponse;

/**
 * @author lipeng
 */
public final class HttpRequestUtils {
  private static final int TIME_OUT = 90000;

  private HttpRequestUtils() {}

  public static MyHttpResponse executeGet(MyHttpRequest request) {
    HttpResponse response =
        HttpRequest.get(request.getUrl())
            .header("Accept", "application/json")
            .timeout(TIME_OUT)
            .execute();
    MyHttpResponse httpResponse = new MyHttpResponse();
    httpResponse.setStatusCode(response.getStatus());
    httpResponse.setBody(response.body());
    return httpResponse;
  }

  public static MyHttpResponse executePost(MyHttpRequest request) {
    HttpResponse response =
        HttpRequest.post(request.getUrl())
            .header("Accept", "application/json")
            .body(request.getBody())
            .timeout(90000)
            .execute();
    MyHttpResponse httpResponse = new MyHttpResponse();
    httpResponse.setStatusCode(response.getStatus());
    httpResponse.setBody(response.body());
    return httpResponse;
  }
}
