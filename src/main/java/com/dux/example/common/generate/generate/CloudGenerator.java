package com.dux.example.common.generate.generate;

import com.dux.example.common.generate.beans.CloudParams;
import com.dux.example.common.generate.beans.ModelBean;
import com.dux.example.common.generate.beans.PropertyBean;
import com.dux.example.common.generate.constants.Constants;
import com.dux.example.common.generate.service.impl.BaseCloudGenerator;
import com.dux.example.common.generate.utils.JdbcUtil;
import com.dux.example.common.generate.utils.ResourceUtil;
import com.dux.example.common.generate.utils.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class CloudGenerator extends BaseCloudGenerator{

  public static void main(String[] args) {
    CloudGenerator.generate();
  }

  public static void generate() {
    // src.main.java的物理路径
    String basePath = ClassLoader.getSystemResource("").getPath().replaceFirst("/", "");
    basePath = basePath.replace("/target/classes/", "") + "/src/main/java/";

    // 获取模板名字集合、包名集合和其它相关信息
    Map<String, String> templateMap = ResourceUtil.getTemplateMap();
    Map<String, String> packageMap = ResourceUtil.getPackageMap();
    String date = new SimpleDateFormat("yyyy/M/d").format(new Date());
    String author = ResourceUtil.getAppValue("app.author");

    ResourceBundle tableResource = Constants.tableResource;
    List<ModelBean> modelBeans = getModelBeans(
            Constants.JDBC_DRIVER,
            Constants.JDBC_URL,
            Constants.JDBC_USERNAME,
            Constants.JDBC_PASSWORD,
            Constants.JDBC_DATABASE,
            Constants.SQL_TABLE_PREFIX);
    System.out.println("modelBeans:" + modelBeans);
    for (ModelBean modelBean : modelBeans) {
      //默认时按下划线转驼峰命名的方式转化表名、表字段名到实体类名、字段名，当两者不能简单的转化时，需要配置名字转化。
      String realModelName = tableResource.getString(modelBean.getTableName().toUpperCase());
      if (!StringUtil.isBlank(realModelName)) {
        modelBean.setModelName(realModelName);
      }
      //设置模板数据
      CloudParams params = new CloudParams();
      params.setModelBean(modelBean);
      params.setPackageMap(packageMap);
      params.setTemplateMap(templateMap);
      params.setOutputPath(Constants.PATH_OUTPUT);
      params.setAuthor(author);
      params.setDate(date);
      BaseCloudGenerator generator = new BaseCloudGenerator();
      generator.generate(params);
    }

  }

  /**
   * 查询模型数据
   * @param jdbcDriver 数据库驱动
   * @param jdbcUrl 连接地址
   * @param jdbcUsername 账号
   * @param jdbcPassword 密码
   * @param database 数据库
   * @param tablePrefix 表名的前缀
   * @return
   */
  public static List<ModelBean> getModelBeans(
          String jdbcDriver,
          String jdbcUrl,
          String jdbcUsername,
          String jdbcPassword,
          String database,
          String tablePrefix) {

    System.out.println("========== 开始查询表 ==========");
    List<ModelBean> modelbeans = new ArrayList<>();
    List<String> params = new ArrayList<>(2);
    try {
      // 查询包含前缀的所有表
      JdbcUtil jdbcUtil = new JdbcUtil(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      params.add(database);
      params.add(tablePrefix);
      List<Map> result = jdbcUtil.selectByParams(Constants.SQL_QUERY_TABLES, params);
      for (Map map : result) {
        String tableName = (String)map.get(Constants.SQL_TABNAME);
        ModelBean modelBean = new ModelBean();
        modelBean.setTableName(tableName);
        modelBean.setModelName(StringUtil.lineToHump(tableName));

        // 查询表所有的列信息
        List<PropertyBean> properties = new ArrayList<>();
        params.clear();
        params.add(database);
        params.add(tableName);
        result = jdbcUtil.selectByParams(Constants.SQL_QUERY_COLUMNS, params);
        for (Map map2 : result) {
          PropertyBean propertyBean = new PropertyBean();
          propertyBean.setColumn((String)map2.get(Constants.SQL_COLNAME));
          propertyBean.setComment((String)map2.get(Constants.SQL_COMMENT));
          propertyBean.setProperty(StringUtil.toLowerCaseFirstOne(StringUtil.lineToHump(propertyBean.getColumn())));
          propertyBean.setJdbcType(StringUtils.upperCase((String)map2.get(Constants.SQL_TYPENAME)));
          propertyBean.setJavaType(ResourceUtil.jdbc2JavaType(propertyBean.getJdbcType()));
          properties.add(propertyBean);
        }

        modelBean.setProperties(properties);
        modelbeans.add(modelBean);
      }
      jdbcUtil.release();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("========== 结束查询表 ==========");
    return modelbeans;
  }
}
