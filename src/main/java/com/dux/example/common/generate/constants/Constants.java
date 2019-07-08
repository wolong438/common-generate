package com.dux.example.common.generate.constants;

import com.dux.example.common.generate.utils.ResourceUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Constants {
  /** 主配置文件 **/
  public static ResourceBundle appResource = ResourceBundle.getBundle("application");
  /** 表名映射文件 **/
  public static ResourceBundle tableResource = ResourceBundle.getBundle("tableName");
  /** 字段类型映射文件 **/
  public static ResourceBundle jdbcTypeResource = ResourceBundle.getBundle("jdbcType");

  /** 数据库驱动 **/
  public static final String JDBC_DRIVER = ResourceUtil.getAppValue("jdbc.driver");
  /** 数据库连接地址 **/
  public static final String JDBC_URL = ResourceUtil.getAppValue("jdbc.url");
  /** 账号 **/
  public static final String JDBC_USERNAME = ResourceUtil.getAppValue("jdbc.username");
  /** 密码 **/
  public static final String JDBC_PASSWORD = ResourceUtil.getAppValue("jdbc.password");
  /** 数据库 **/
  public static final String JDBC_DATABASE = ResourceUtil.getAppValue("jdbc.database");

  /** 查询数据库的表的语句 */
  public static final String SQL_QUERY_TABLES = ResourceUtil.getAppValue("sql.queryTables");
  /** 查询数据库的列的语句 **/
  public static final String SQL_QUERY_COLUMNS = ResourceUtil.getAppValue("sql.queryColumns");
  /** 查询的表名前缀 **/
  public static final String SQL_TABLE_PREFIX = ResourceUtil.getAppValue("sql.tablePrefix");
  /** 表字段名 **/
  public static final String SQL_TABNAME = ResourceUtil.getAppValue("sql.tabName");
  /** 列字段名 **/
  public static final String SQL_COLNAME = ResourceUtil.getAppValue("sql.colName");
  /** 列字段的数据类型 **/
  public static final String SQL_TYPENAME = ResourceUtil.getAppValue("sql.typeName");
  /** 列字段的注释 **/
  public static final String SQL_COMMENT = ResourceUtil.getAppValue("sql.comment");


  //=====================================下面的常量根据需要自行添加============================================

  /** 应用名 **/
  public static final String APP_NAME = "app.name";
  /** 创建人 */
  public static final String APP_AUTHOR = "app.author";
  /** 创建时间 **/
  public static final String APP_DATE = new SimpleDateFormat("yyyy/M/d").format(new Date());

  /** 创建人 */
  public static final String PATH_OUTPUT = ResourceUtil.getAppValue("path.output");








}
