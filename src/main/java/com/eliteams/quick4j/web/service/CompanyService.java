package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.Company;

public interface CompanyService extends GenericService<Company, Long> {
    String getComanyNameById(Long id);
}
