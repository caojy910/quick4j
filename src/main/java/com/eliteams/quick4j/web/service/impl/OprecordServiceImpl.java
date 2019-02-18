package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.OprecordMapper;
import com.eliteams.quick4j.web.model.Oprecord;
import com.eliteams.quick4j.web.model.OprecordExample;
import com.eliteams.quick4j.web.service.OprecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OprecordServiceImpl extends GenericServiceImpl<Oprecord, Long> implements OprecordService {

    @Resource
    OprecordMapper oprecordMapper;

    @Override
    public int insert(Oprecord model) {
        return oprecordMapper.insertSelective(model);
    }

    @Override
    public int update(Oprecord model) {
        return oprecordMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return oprecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Oprecord selectById(Long id) {
        return oprecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<Oprecord, Long> getDao() {
        return oprecordMapper;
    }

    @Override
    public List<Oprecord> getOprecordListByDeviceId(Long id, Long engineerid) {
        OprecordExample example = new OprecordExample();
        OprecordExample.Criteria criteria = example.createCriteria().andDeciveidEqualTo(id);
        if (engineerid != null)
            criteria.andOpengineerEqualTo(engineerid);
        return oprecordMapper.selectByExample(example);
    }

}
