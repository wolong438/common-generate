package com.dux.example.common.generate.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceUtil {
  /** 主配置文件 **/
  private static ResourceBundle appResource = ResourceBundle.getBundle("application");
  /** 字段类型映射文件 **/
  private static ResourceBundle jdbcTypeResource = ResourceBundle.getBundle("jdbcType");
  /** 模板文件前缀 */
  public static final String TEMPLATE_SUFFIX = "template.";
  /** 包路径前缀 */
  public static final String PACKAGE_SUFFIX = "package.";
  /** 基础包路径前缀 */
  public static final String BASE_PATH_KEY = "package.base";

  public static String getAppValue(String key) {
    return appResource.getString(key);
  }

  /**
   * 查找jdbcType对应的javaType
   * @param jdbcType
   * @return
   */
  public static String jdbc2JavaType(String jdbcType) {
    if (!jdbcTypeResource.containsKey(jdbcType)) {
      return "Object";
    }
    return jdbcTypeResource.getString(jdbcType);
  }

  /**
   * 读取模板文件路径属性
   */
  public static Map<String, String> getTemplateMap() {
    Map<String, String> templateMap = new HashMap<>();
    Set<String> keySet = appResource.keySet();
    for (String key : keySet) {
      if (key.startsWith(TEMPLATE_SUFFIX)) {
        templateMap.put(key.replace(TEMPLATE_SUFFIX, ""), appResource.getString(key));
      }
    }
    return templateMap;
  }

  /**
   * 读取包路径属性
   */
  public static Map<String, String> getPackageMap() {
    Map<String, String> packageMap = new HashMap<>();
    String basePackage = appResource.getString(BASE_PATH_KEY);
    String basePackagePlaceHolder = "${" +BASE_PATH_KEY+ "}";

    Set<String> keySet = appResource.keySet();
    for (String key : keySet) {
      if (key.startsWith(PACKAGE_SUFFIX)) {
        String packagePath = appResource.getString(key);
        packageMap.put(key.replace(PACKAGE_SUFFIX, ""), packagePath.replace(basePackagePlaceHolder, basePackage));
      }
    }
    return packageMap;
  }


}
