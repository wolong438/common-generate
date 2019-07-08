package com.dux.example.common.generate.beans;

import java.util.List;

/**
 * 数据模型
 */
public class ModelBean {
  /** 实体名字 **/
  private String modelName;
  /** 实体对应的表名 **/
  private String tableName;
  /** 实体属性 **/
  private List<PropertyBean> properties;

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public List<PropertyBean> getProperties() {
    return properties;
  }

  public void setProperties(List<PropertyBean> properties) {
    this.properties = properties;
  }
}
