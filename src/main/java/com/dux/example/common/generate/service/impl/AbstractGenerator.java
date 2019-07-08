package com.dux.example.common.generate.service.impl;

import com.dux.example.common.generate.beans.Params;
import com.dux.example.common.generate.constants.FileType;
import com.dux.example.common.generate.service.Generator;
import com.dux.example.common.generate.utils.StringUtil;
import com.dux.example.common.generate.utils.TemplateUtil;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

public abstract class AbstractGenerator implements Generator {
  private Params params;

  public Params getParams() {
    return params;
  }

  public void setParams(Params params) {
    this.params = params;
  }

  /**
   * 构建文件路径
   * @param params 参数对象
   * @param fileType 文件类型
   * @return
   */
  private String[] buildFilepath(Params params, FileType fileType) {
    String[] filepath = new String[2];

    String outputPath = params.getOutputPath();
    if (StringUtil.isBlank(outputPath)) {
      outputPath = "D:/generate/";
    }

    String filename = null;
    String modelName = null;
    if (params.getModelBean() != null) {
      modelName = params.getModelBean().getModelName();
    }
    boolean isBaseFile = fileType.name().startsWith("BASE");
    if (isBaseFile) {
      filename = fileType.getSuffix();
    } else {
      filename = String.valueOf(modelName) + fileType.getSuffix();
    }
    filepath[1] = filename;

    String packageKey = fileType.getHumpName();
    Map<String, String> packageMap = params.getPackageMap();
    if (packageMap != null) {
      String packageValue = packageMap.get(packageKey);
      if (!StringUtil.isBlank(packageValue)) {
        String parentPath = outputPath + "/" + packageValue.replaceAll("\\.", "/") + "/";
        filepath[0] = parentPath;
      }
    }
   return filepath;

  }

  public void create(Params params, FileType fileType) {
    if (params == null) {
      System.err.println("创建文件失败，原因：缺少重要参数，Params={" + params + "}");
      return;
    }

    // 构建文件路径
    String[] filepath = buildFilepath(params, fileType);
    String parentPath = filepath[0];
    String fileName = filepath[1];
    if (StringUtil.isBlank(parentPath) || StringUtil.isBlank(fileName)) {
      System.err.println("创建文件失败，构建文件路径异常。Params={" + params + "}，filepath={" + parentPath + fileName + "}");
      return;
    }

    // 创建文件
    File file = new File(parentPath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String filePath = parentPath + fileName;
    file = new File(filePath);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        System.err.println("创建文件失败,"+ e.getMessage());
        System.err.println("文件："+ file.getPath());
        return;
      }
    }

    // 写入数据
    Map<String, String> templateMap = params.getTemplateMap();
    String templteKey = fileType.getHumpName();
    if (templateMap != null) {
      String templateValue = templateMap.get(templteKey);
      try {
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"),10240);
        Template template = TemplateUtil.getTemplate(templateValue);
        template.process(params, out);
      } catch (Exception e) {
        System.err.println("文件写入数据失败,"+ e.getMessage());e.printStackTrace();
        System.err.println("文件："+ file.getPath());
        return;
      }
    }
    System.out.println("文件写入数据成功——" + file.getPath());
  }
}
