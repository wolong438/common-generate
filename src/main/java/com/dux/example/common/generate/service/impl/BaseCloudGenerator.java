package com.dux.example.common.generate.service.impl;

import com.dux.example.common.generate.beans.Params;
import com.dux.example.common.generate.constants.FileType;
import com.dux.example.common.generate.service.BaseDao;
import com.dux.example.common.generate.service.CloudService;
import com.dux.example.common.generate.service.Common;

public class BaseCloudGenerator extends AbstractGenerator implements Common, BaseDao, CloudService{

  @Override
  public void generate(Params params) {
    createModel(params);
    createXml(params);
    createMapper(params);
    createBaseMapper(params);
    createDao(params);
    createDaoImpl(params);
    createBaseDao(params);
    createBaseDaoImpl(params);
    createService(params);
    createServiceImpl(params);
    createServiceApi(params);
    createServiceClient(params);
    createController(params);
  }

  @Override
  public void createModel(Params params) {
    create(params, FileType.MODEL);
  }

  @Override
  public void createXml(Params params) {
    create(params, FileType.XML);
  }

  @Override
  public void createMapper(Params params) {
    create(params, FileType.MAPPER);
  }

  @Override
  public void createDao(Params params) {
    create(params, FileType.DAO);
  }

  @Override
  public void createDaoImpl(Params params) {
    create(params, FileType.DAO_IMPL);
  }

  @Override
  public void createService(Params params) {
    create(params, FileType.SERVICE);
  }

  @Override
  public void createServiceImpl(Params params) {
    create(params, FileType.SERVICE_IMPL);
  }

  @Override
  public void createController(Params params) {
    create(params, FileType.CONTROLLER);
  }

  @Override
  public void createBaseMapper(Params params) {
    create(params, FileType.BASE_MAPPER);
  }

  @Override
  public void createBaseDao(Params params) {
    create(params, FileType.BASE_DAO);
  }

  @Override
  public void createBaseDaoImpl(Params params) {
    create(params, FileType.BASE_DAO_IMPL);
  }

  @Override
  public void createServiceApi(Params params) {
    create(params, FileType.SERVICE_API);
  }

  @Override
  public void createServiceClient(Params params) {
    create(params, FileType.SERVICE_Client);
  }

}
