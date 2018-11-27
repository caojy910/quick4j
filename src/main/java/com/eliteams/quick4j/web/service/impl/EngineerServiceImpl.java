package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.DeviceMapper;
import com.eliteams.quick4j.web.dao.EngineerMapper;
import com.eliteams.quick4j.web.model.Device;
import com.eliteams.quick4j.web.model.DeviceExample;
import com.eliteams.quick4j.web.model.Engineer;
import com.eliteams.quick4j.web.model.EngineerExample;
import com.eliteams.quick4j.web.service.DeviceService;
import com.eliteams.quick4j.web.service.EngineerService;
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
public class EngineerServiceImpl extends GenericServiceImpl<Engineer, Long> implements EngineerService {

    @Resource
    private EngineerMapper engineerMapper;

    @Override
    public int insert(Engineer model) {
        return engineerMapper.insertSelective(model);
    }

    @Override
    public int update(Engineer model) {
        return engineerMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return engineerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Engineer selectById(Long id) {
        return engineerMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<Engineer, Long> getDao() {
        return engineerMapper;
    }

    @Override
    public int getEngineerCount() {
        return engineerMapper.countByExample(new EngineerExample());
    }

    @Override
    public int getEngineerCountByType(int type) {
        EngineerExample example = new EngineerExample();
        example.createCriteria().andTypeEqualTo(type);
        return engineerMapper.countByExample(example);
    }

    @Override
    public List<Engineer> getEngineers() {
        EngineerExample example = new EngineerExample();
        return engineerMapper.selectByExample(example);
    }

    @Override
    public List<Engineer> getLocalEngineers() {
        EngineerExample example = new EngineerExample();
        example.createCriteria().andTypeEqualTo(0);
        return engineerMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Engineer> getRemoteEngineers() {
        EngineerExample example = new EngineerExample();
        example.createCriteria().andTypeEqualTo(1);
        return engineerMapper.selectByExample(example);
    }

    @Override
    public byte[] getHeadImgByEngieerId(Long id) {
        EngineerExample example = new EngineerExample();
        example.createCriteria().andIdEqualTo(id);
        List<Engineer> engineers = engineerMapper.selectByExampleWithBLOBs(example);
        if (engineers != null && engineers.size() > 0) {
            return engineers.get(0).getHeadimg();
        }
        return null;
    }

}
