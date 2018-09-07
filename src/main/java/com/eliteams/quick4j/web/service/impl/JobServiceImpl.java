package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.EngineerMapper;
import com.eliteams.quick4j.web.dao.JobMapper;
import com.eliteams.quick4j.web.model.Engineer;
import com.eliteams.quick4j.web.model.EngineerExample;
import com.eliteams.quick4j.web.model.Job;
import com.eliteams.quick4j.web.model.JobExample;
import com.eliteams.quick4j.web.service.EngineerService;
import com.eliteams.quick4j.web.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类
 *
 * @author StarZou
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class JobServiceImpl extends GenericServiceImpl<Job, Long> implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Override
    public int insert(Job model) {
        return jobMapper.insertSelective(model);
    }

    @Override
    public int update(Job model) {
        return jobMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return jobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Job selectById(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<Job, Long> getDao() {
        return jobMapper;
    }

    @Override
    public int getJobCount() {
        return jobMapper.countByExample(new JobExample());
    }

    @Override
    public int getJobCountByType(int type) {
        JobExample example = new JobExample();
        example.createCriteria().andTypeEqualTo(type);
        return jobMapper.countByExample(example);
    }

    @Override
    public List<Job> getHistoryJobs() {
        JobExample example = new JobExample();
        example.createCriteria().andJobstateEqualTo(0);
        return jobMapper.selectByExample(example);
    }

    @Override
    public List<Job> getTodoJobs() {
        JobExample example = new JobExample();
        example.createCriteria().andJobstateEqualTo(1);
        return jobMapper.selectByExample(example);
    }
}
