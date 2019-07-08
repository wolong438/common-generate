package com.dux.example.common.generate.beans;

import java.util.Map;

/**
 * 参数类
 */
public class Params {
  /**
   * 实体对象
   */
  private ModelBean modelBean;
  /**
   * 包名集合
   */
  private Map<String, String> packageMap;

  /**
   * 模板名集合
   */
  private Map<String, String> templateMap;

  /**
   * 文件输出路径
   */
  private String outputPath;

  public ModelBean getModelBean() {
    return modelBean;
  }

  public void setModelBean(ModelBean modelBean) {
    this.modelBean = modelBean;
  }

  public Map<String, String> getPackageMap() {
    return packageMap;
  }

  public void setPackageMap(Map<String, String> packageMap) {
    this.packageMap = packageMap;
  }

  public Map<String, String> getTemplateMap() {
    return templateMap;
  }

  public void setTemplateMap(Map<String, String> templateMap) {
    this.templateMap = templateMap;
  }

  public String getOutputPath() {
    return outputPath;
  }

  public void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }
}
