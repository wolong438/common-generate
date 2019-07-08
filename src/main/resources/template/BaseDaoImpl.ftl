package ${packageMap.baseDaoImpl};

import java.util.List;

import ${packageMap.baseDao}.BaseDao;
import ${packageMap.baseMapper}.BaseMapper;

/**
* 基础数据访问类
* BaseDao在mybatis中的实现
* @author ${author}
* @date ${date}
*
* @param <Mapper> SQL映射对象
* @param <Model> 实体类
*/
public abstract class BaseDaoImpl<Mapper, Model> implements BaseDao<Mapper, Model>{

@Override
public long count(Model model) {
  try {
    return getMapper().count(model);
  } catch (Exception e) {
    e.printStackTrace();
}
return 0L;
}

@Override
public List<Model> select(Model model) {
    try {
    return getMapper().select(model);
    } catch (Exception e) {
    e.printStackTrace();
    }
    return null;
    }

    @Override
    public Model selectByPrimaryKey(Object id) {
    try {
    return getMapper().selectByPrimaryKey(id);
    } catch (Exception e) {
    e.printStackTrace();
    }
    return null;
    }


    @Override
    public void delete(Model model) {
    try {
    getMapper().delete(model);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void deleteByPrimaryKey(Object id) {
    try {
    getMapper().deleteByPrimaryKey(id);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void deleteByPrimaryKeys(String ids, String separator) {
    if (isEmpty(ids)) {
    return;
    }

    if (isEmpty(separator)) {
    separator = ",";
    }

    try {
    String[] idArray = ids.split(separator);
    for (String idStr : idArray) {
    if (isEmpty(idStr)) {
    continue;
    }
    getMapper().deleteByPrimaryKey(idStr);
    }
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void insert(Model model) {
    try {
    getMapper().insert(model);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void insertSelective(Model model) {
    try {
    getMapper().insertSelective(model);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void update(Model model) {
    try {
    getMapper().update(model);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void updateByPrimaryKey(Model model) {
    try {
    getMapper().updateByPrimaryKey(model);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    @Override
    public void updateByPrimaryKeySelective(Model model) {
    try {
    getMapper().updateByPrimaryKeySelective(model);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage(), e);
    }
    }

    public boolean isEmpty(final CharSequence cs) {
    return cs == null || cs.length() == 0;
    }

    public abstract BaseMapper<Model> getMapper();

}
