package com.dux.example.common.generate.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
  private static Pattern linePattern = Pattern.compile("_(\\w)");

  /**
   * 下划线转驼峰
   * @param str
   * @return
   */
  public static String lineToHump(String str) {
    if (null == str || "".equals(str)) {
      return str;
    }
    str = str.toLowerCase();
    Matcher matcher = linePattern.matcher(str);
    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
      matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
    }
    matcher.appendTail(sb);

    str = sb.toString();
    str = str.substring(0, 1).toUpperCase() + str.substring(1);

    return str;
  }

  /**
   * 首字母转小写
   * @param s
   * @return
   */
  public static String toLowerCaseFirstOne(String s) {
    if (StringUtils.isBlank(s)) {
      return s;
    }
    if (Character.isLowerCase(s.charAt(0))) {
      return s;
    } else {
      return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
  }

  /**
   * 检查空字符串
   * @param str
   * @return
   */
  public static boolean isBlank(String str) {
    int strLen;
    if (str != null && (strLen = str.length()) != 0) {
      for(int i = 0; i < strLen; ++i) {
        if (!Character.isWhitespace(str.charAt(i))) {
          return false;
        }
      }

      return true;
    } else {
      return true;
    }
  }
}
