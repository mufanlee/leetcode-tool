package com.mufan.leetcode.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lipeng
 */
@Setter
@Getter
public class MyHttpResponse {
  private int statusCode;

  private String body;

  private String url;
}
