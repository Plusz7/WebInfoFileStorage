package com.exercise.storage.service;

import com.exercise.storage.model.persistent.DbWebInfo;
import com.exercise.storage.repository.WebInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WebInfoServiceImpl implements WebInfoService {

    private final WebInfoRepository webInfoRepository;

    @Override
    public void saveWebInfo(String source) {
        DbWebInfo dbWebInfo = new DbWebInfo();
        dbWebInfo.setUrl(source);
        String[] split = source.split("\\.");
        dbWebInfo.setName(split[1]);
        webInfoRepository.save(dbWebInfo);
    }

    @Override
    public List<DbWebInfo> getWebInfoList() {
        return (List<DbWebInfo>) webInfoRepository.findAll();
    }

    @Override
    public Optional<DbWebInfo> findWebInfo(String id) {
        return webInfoRepository.findById(Long.valueOf(id));
    }


}
