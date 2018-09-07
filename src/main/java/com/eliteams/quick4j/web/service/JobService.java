package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.Job;

import java.util.List;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface JobService extends GenericService<Job, Long> {


    int getJobCount();

    int getJobCountByType(int type);

    List<Job> getHistoryJobs();

    List<Job> getTodoJobs();
}
