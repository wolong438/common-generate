package ${packageMap.mapper};

import java.util.List;

public interface BaseMapper<Model> {

    long count(Model model);

    List<Model> select(Model model);

    Model selectByPrimaryKey(Object id);

    int delete(Model model);

    int deleteByPrimaryKey(Object id);

    int deleteByPrimaryKeys(String ids);

    int insert(Model model);

    int insertSelective(Model model);

    int update(Model model);

    int updateByPrimaryKey(Model model);

    int updateByPrimaryKeySelective(Model model);

}
