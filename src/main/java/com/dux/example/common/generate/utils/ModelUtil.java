package com.dux.example.common.generate.utils;

import java.io.File;

/**
 * 获取项目的实体名和表名
 */
public class ModelUtil {
  private static final String suffix = "Schema.java";

  public static void main(String[] args) {
    String path = "G:\\eclipse-workspace\\resources_code\\src\\com\\sinosoft\\lis\\schema";
    printName(path);
  }

  public static void printName(String dirPath) {
    File dir = new File(dirPath);
    if (!(dir.exists() && dir.isDirectory())) {
      return;
    }

    File[] files = dir.listFiles();
    for (File file : files) {
      String filename = file.getName();
      if (filename.endsWith(suffix)) {
        String name = filename.replace(suffix, "");
        System.out.println(name.toUpperCase() + "=" + name);
      }
    }
  }
}
