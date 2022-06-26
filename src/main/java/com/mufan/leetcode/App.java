package com.mufan.leetcode;

/** Hello world! */
public class App {
  private static final String rootPath =
      "D:\\workspace\\leetcode-tool\\src\\main\\resources\\doc\\";

  public static void main(String[] args) {
    System.out.println("Hello World!");
    WeeklyContestManager.generateNote(298, rootPath);
    WeeklyContestManager.generateNote(299, rootPath);
  }
}
