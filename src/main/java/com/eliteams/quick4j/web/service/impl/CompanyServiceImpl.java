package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.CompanyMapper;
import com.eliteams.quick4j.web.model.Company;
import com.eliteams.quick4j.web.model.CompanyExample;
import com.eliteams.quick4j.web.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl extends GenericServiceImpl<Company, Long> implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public String getComanyNameById(Long id) {
        CompanyExample example = new CompanyExample();
        example.createCriteria().andIdEqualTo(id);
        List<Company> companyList = companyMapper.selectByExample(example);
        if (companyList == null || companyList.size() == 0)
            return "noName";

        return companyList.get(0).getName();
    }


    @Override
    public int insert(Company model) {
        return companyMapper.insertSelective(model);
    }

    @Override
    public int update(Company model) {
        return companyMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Company selectById(Long id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<Company, Long> getDao() {
        return companyMapper;
    }

}
