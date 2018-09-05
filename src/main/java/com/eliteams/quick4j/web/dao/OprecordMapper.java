package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.web.model.Oprecord;
import com.eliteams.quick4j.web.model.OprecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OprecordMapper {
    int countByExample(OprecordExample example);

    int deleteByExample(OprecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Oprecord record);

    int insertSelective(Oprecord record);

    List<Oprecord> selectByExample(OprecordExample example);

    Oprecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Oprecord record, @Param("example") OprecordExample example);

    int updateByExample(@Param("record") Oprecord record, @Param("example") OprecordExample example);

    int updateByPrimaryKeySelective(Oprecord record);

    int updateByPrimaryKey(Oprecord record);
}