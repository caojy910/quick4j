package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.core.util.SessionUtils;
import com.eliteams.quick4j.web.dao.EngineerMapper;
import com.eliteams.quick4j.web.dao.JobMapper;
import com.eliteams.quick4j.web.model.*;
import com.eliteams.quick4j.web.service.EngineerService;
import com.eliteams.quick4j.web.service.JobService;
import com.eliteams.quick4j.web.service.RoleService;
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

    @Resource
    private RoleService roleService;

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
        return getJobListByJobState(2);
    }

    @Override
    public List<Job> getTodoJobs() {
        return getJobListByJobState(0);
    }

    @Override
    public List<Job> getDoingJobs() {
        return getJobListByJobState(1);
    }

    private List<Job> getJobListByJobState(int state) {
        JobExample example = new JobExample();

        User user = (User) SessionUtils.getRequest().getSession().getAttribute("userInfo");
        if (user == null || user.getCompanyid() == null)
            return null;
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        if (!isAdminRole(roleInfos)) {
            JobExample.Criteria criteria1 = example.createCriteria();
            criteria1.andCompanyidEqualTo(user.getCompanyid()).andJobstateEqualTo(state).andLocalengineeridEqualTo(user.getId());
            JobExample.Criteria criteria2 = example.createCriteria();
            criteria2.andCompanyidEqualTo(user.getCompanyid()).andJobstateEqualTo(state).andRemoteengineeridEqualTo(user.getId());
            example.or(criteria1);
            example.or(criteria2);
        }
        else
            example.createCriteria().andCompanyidEqualTo(user.getCompanyid()).andJobstateEqualTo(state);

        return jobMapper.selectByExample(example);
    }

    private boolean isAdminRole(List<Role> roleInfos) {
        for (Role role : roleInfos) {
            if (role != null) {
                if (role.getRoleName().contains("admin"))
                    return true;
            }
        }
        return false;
    }

    public boolean updateJobstateById(Long id, int jobstate) {
        JobExample example = new JobExample();
        example.createCriteria().andIdEqualTo(id);
        List<Job> job = jobMapper.selectByExample(example);
        for (Job curjob : job) {
            curjob.setJobstate(jobstate);
            jobMapper.updateByExample(curjob, example);
        }

        return true;
    }

}
