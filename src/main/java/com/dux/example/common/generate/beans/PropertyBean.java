package com.dux.example.common.generate.beans;

/**
 * 结果映射
 */
public class PropertyBean {

  /** 属性名 **/
  private String property;
  /** 字段名 **/
  private String column;
  /** java类型 **/
  private String javaType;
  /** jdbc类型 **/
  private String jdbcType;
  /** 字段注释 **/
  private String comment;

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getJavaType() {
    return javaType;
  }

  public void setJavaType(String javaType) {
    this.javaType = javaType;
  }

  public String getJdbcType() {
    return jdbcType;
  }

  public void setJdbcType(String jdbcType) {
    this.jdbcType = jdbcType;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
