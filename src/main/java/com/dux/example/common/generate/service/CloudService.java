package com.dux.example.common.generate.service;

import com.dux.example.common.generate.beans.Params;

/**
 * springcloud微服务接口
 */
public interface CloudService {

  void createServiceApi(Params params);

  void createServiceClient(Params params);

}
