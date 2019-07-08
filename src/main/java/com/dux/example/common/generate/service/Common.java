package com.dux.example.common.generate.service;

import com.dux.example.common.generate.beans.Params;

/**
 * 常规接口
 */
public interface Common {
  void createModel(Params params);

  void createXml(Params params);

  void createMapper(Params params);

  void createDao(Params params);

  void createDaoImpl(Params params);

  void createService(Params params);

  void createServiceImpl(Params params);

  void createController(Params params);
}
