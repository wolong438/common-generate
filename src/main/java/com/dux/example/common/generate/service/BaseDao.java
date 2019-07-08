package com.dux.example.common.generate.service;

import com.dux.example.common.generate.beans.Params;

/**
 * 基本的数据库访问接口
 */
public interface BaseDao {

  void createBaseMapper(Params params);

  void createBaseDao(Params params);

  void createBaseDaoImpl(Params params);

}
