package com.dux.example.common.generate.service;

import com.dux.example.common.generate.beans.Params;
import com.dux.example.common.generate.constants.FileType;

/**
 * 生成java文件的接口
 */
public interface Generator {

  void generate(Params params);

}
