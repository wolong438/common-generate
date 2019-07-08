package ${packageMap.baseDao};

import java.util.List;

/**
* BaseDao 基础的数据库访问接口
* @author ${author}
* @date ${date}
*
* @param <Mapper> SQL映射对象
* @param <Model> 实体类
*/
public interface BaseDao<Mapper, Model> {
    long count(Model model);

    List<Model> select(Model model);

    Model selectByPrimaryKey(Object id);

    void delete(Model model);

    void deleteByPrimaryKey(Object id);

    void deleteByPrimaryKeys(String ids, String separator);

    void insert(Model model);

    void insertSelective(Model model);

    void update(Model model);

    void updateByPrimaryKey(Model model);

    void updateByPrimaryKeySelective(Model model);
}