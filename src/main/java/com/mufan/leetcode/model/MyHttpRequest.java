package com.mufan.leetcode.model;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lipeng
 */
public class MyHttpRequest {

  private final String url;

  private String body;

  private final String contentType;

  private final Map<String, String> Header = new HashMap<>();

  public static MyHttpRequest get(String url) {
    return new MyHttpRequest(url, null);
  }

  public static MyHttpRequest post(String url, String contentType) {
    return new MyHttpRequest(url, contentType);
  }

  public static MyHttpRequest put(String url, String contentType) {
    return new MyHttpRequest(url, contentType);
  }

  private MyHttpRequest(String url, String contentType) {
    this.url = url;
    this.contentType = contentType;
  }

  public String getUrl() {
    return url;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getContentType() {
    return contentType;
  }

  public void addHeader(String name, String value) {
    Header.put(name, value);
  }

  public Map<String, String> getHeader() {
    return Header;
  }

  public void addParam(String key, String value) throws UnsupportedEncodingException {
    if (body == null || body.isEmpty()) {
      body = key + "=" + value;
    } else {
      body = body + "&" + key + "=" + value;
    }
  }
}
