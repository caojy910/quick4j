package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.Engineer;
import com.eliteams.quick4j.web.model.EngineerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EngineerMapper extends GenericDao<Engineer, Long> {
    int countByExample(EngineerExample example);

    int deleteByExample(EngineerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Engineer record);

    int insertSelective(Engineer record);

    List<Engineer> selectByExample(EngineerExample example);

    Engineer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Engineer record, @Param("example") EngineerExample example);

    int updateByExample(@Param("record") Engineer record, @Param("example") EngineerExample example);

    int updateByPrimaryKeySelective(Engineer record);

    int updateByPrimaryKey(Engineer record);
}