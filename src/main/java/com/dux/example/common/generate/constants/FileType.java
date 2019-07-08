package com.dux.example.common.generate.constants;

import com.dux.example.common.generate.utils.StringUtil;

/**
 * 文件类型枚举类
 */
public enum FileType {

  MODEL(".java", "实体"),

  MAPPER("Mapper.java", "查询映射"),
  BASE_MAPPER("BaseMapper.java", "查询映射"),
  XML("Mapper.xml", "查询语句配置"),

  DAO("Dao.java", "数据库访问"),
  BASE_DAO("BaseDao.java", "数据库访问接口"),
  DAO_IMPL("DaoImpl.java", "数据库访问的实现"),
  BASE_DAO_IMPL("BaseDaoImpl.java", "数据库访问接口的抽象"),

  SERVICE("Service.java", "业务接口"),
  SERVICE_IMPL("ServiceImpl.java", "业务接口实现"),
  SERVICE_API("Api.java", "服务接口"),
  SERVICE_Client("Client.java", "服务接口的实现"),

  CONTROLLER("Controller.java", "请求控制器"),
  ;

  /**
   * 文件名后缀
   */
  private String suffix;
  /**
   * 文件描述
   */
  private String desc;

  FileType(String suffix, String desc){
    this.suffix = suffix;
    this.desc = desc;
  }


  /**
   * 获取驼峰命名的名字
   * exam: BASE_DAO => baseDao
   * @return
   */
  public String getHumpName() {
    return StringUtil.toLowerCaseFirstOne(StringUtil.lineToHump(this.name()));
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
