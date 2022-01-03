package com.exercise.storage.service;

import com.exercise.storage.model.dto.WebInfoDto;
import com.exercise.storage.model.persistent.DbWebInfo;
import com.exercise.storage.repository.WebInfoRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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
    public DbWebInfo findWebInfo(String id) {
        Optional<DbWebInfo> byId = webInfoRepository.findById(Long.valueOf(id));
        return byId.orElse(null);
    }

    @Override
    public InputStreamResource collectResource(DbWebInfo webInfo) throws IOException {
            File file = new File(webInfo.getName() + ".html");
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
                bufferedWriter.write(Jsoup.connect(webInfo.getUrl()).get().html());
            }
            return new InputStreamResource(new FileInputStream(file));
            }
    }

