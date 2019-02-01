package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.core.util.SessionUtils;
import com.eliteams.quick4j.web.dao.DeviceMapper;
import com.eliteams.quick4j.web.model.Device;
import com.eliteams.quick4j.web.model.DeviceExample;
import com.eliteams.quick4j.web.model.Role;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.service.DeviceService;
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
public class DeviceServiceImpl extends GenericServiceImpl<Device, Long> implements DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    @Resource
    private RoleService roleService;

    @Override
    public int insert(Device model) {
        return deviceMapper.insertSelective(model);
    }

    @Override
    public int update(Device model) {
        return deviceMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return deviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Device selectById(Long id) {
        return deviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<Device, Long> getDao() {
        return deviceMapper;
    }

    @Override
    public int getDeviceCount() {
        DeviceExample example = new DeviceExample();
        addRoleCondition(example);
        return deviceMapper.countByExample(example);
    }

    @Override
    public int getDeviceCountByState(int state) {
        DeviceExample example = new DeviceExample();
        example.createCriteria().andStateEqualTo(state);
        addRoleCondition(example);
        return deviceMapper.countByExample(example);
    }

    @Override
    public List<Device> getDevices() {
        DeviceExample example = new DeviceExample();
        addRoleCondition(example);
        return deviceMapper.selectByExample(example);
    }

    private boolean hasRole(String roleName) {
        User user = (User) SessionUtils.getRequest().getSession().getAttribute("userInfo");
        if (user == null || user.getCompanyid() == null)
            return false;
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
            if (role != null) {
                if (role.getRoleName().contains(roleName))
                    return true;
            }
        }

        return false;
    }

    private void addRoleCondition(DeviceExample example) {
        if (example == null)
            return;
        User user = (User) SessionUtils.getRequest().getSession().getAttribute("userInfo");
        if (user == null || user.getCompanyid() == null)
            return;
        if (hasRole("manufactor"))
            example.createCriteria().andManufactoridEqualTo(user.getCompanyid());
        else if (hasRole("customer"))
            example.createCriteria().andCustomeridEqualTo(user.getCompanyid());
        else
            example.createCriteria().andCompanyidEqualTo(user.getCompanyid());
    }
}
