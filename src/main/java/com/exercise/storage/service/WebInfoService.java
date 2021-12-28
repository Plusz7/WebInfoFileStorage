package com.exercise.storage.service;

import com.exercise.storage.model.persistent.DbWebInfo;

import java.util.List;
import java.util.Optional;

public interface WebInfoService {
    void saveWebInfo(String name);
    List<DbWebInfo> getWebInfoList();
    Optional<DbWebInfo> findWebInfo(String id);
}
