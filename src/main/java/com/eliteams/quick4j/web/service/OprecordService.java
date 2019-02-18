package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.Oprecord;

import java.util.List;

public interface OprecordService extends GenericService<Oprecord, Long> {
    List<Oprecord> getOprecordListByDeviceId(Long id, Long engineerid);
}
