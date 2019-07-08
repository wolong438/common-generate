package com.dux.example.common.generate.beans;

import com.dux.example.common.generate.beans.Params;

public class CloudParams extends Params {
  /**
   * 作者
   */
  private String author;

  /**
   * 日期
   */
  private String date;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
