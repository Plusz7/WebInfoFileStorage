package com.exercise.storage.service;

import com.exercise.storage.model.persistent.DbWebInfo;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.util.List;

public interface WebInfoService {
    void saveWebInfo(String name);
    List<DbWebInfo> getWebInfoList();
    DbWebInfo findWebInfo(String id);
    InputStreamResource collectResource(DbWebInfo webInfo) throws IOException;
}
