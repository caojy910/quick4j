package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.Company;

import java.util.List;

public interface CompanyService extends GenericService<Company, Long> {
    String getComanyNameById(Long id);

    List<Company> getCompanyList();
}
