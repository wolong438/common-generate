package com.dux.example.common.generate.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

/**
 * freemarker模板工具类
 *  2019/07/05
 */
public class TemplateUtil {
  private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);
  private static final String BASE_PACKAGE_PATH = "/template";

  static{
    //这里比较重要，用来指定加载模板所在的路径
    CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(TemplateUtil.class, BASE_PACKAGE_PATH));
    CONFIGURATION.setDefaultEncoding("UTF-8");
    CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
  }

  /**
   * 设置模板包所在路径
   * @param basePackagePath
   */
  public static void setBasePackagePath(String basePackagePath) {
    CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(TemplateUtil.class, basePackagePath));
  }

  /**
   * 重置模板包所在路径，默认路径为/template
   */
  public static void resetBasePackagePath() {
    CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(TemplateUtil.class, BASE_PACKAGE_PATH));
  }

  /**
   * 获取模板
   * @param templateName 模板名字
   * @return
   * @throws IOException
   */
  public static Template getTemplate(String templateName) throws IOException {
    return CONFIGURATION.getTemplate(templateName);
  }

  public static void clearCache() {
    CONFIGURATION.clearTemplateCache();
  }


}
