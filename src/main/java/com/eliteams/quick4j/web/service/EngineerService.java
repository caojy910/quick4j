package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.Device;
import com.eliteams.quick4j.web.model.Engineer;

import java.util.List;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface EngineerService extends GenericService<Engineer, Long> {


    int getEngineerCount();

    int getEngineerCountByType(int type);

    List<Engineer> getEngineers();

    List<Engineer> getLocalEngineers();

    List<Engineer> getRemoteEngineers();

    byte[] getHeadImgByEngieerId(Long id);
}
