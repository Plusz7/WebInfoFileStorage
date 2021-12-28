package com.exercise.storage.service;

import com.exercise.storage.model.persistent.DbFile;
import com.exercise.storage.repository.FilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FilesServiceImpl implements FilesService {

    private final FilesRepository filesRepository;

    public void saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        DbFile dbFile = DbFile.builder()
                .name(file.getName())
                .content(file.getBytes())
                .size(String.valueOf(file.getSize()))
                .type(file.getContentType())
                .build();
        filesRepository.save(dbFile);
    }

    public DbFile getFile(String id){
        return filesRepository.findById(Long.valueOf(id)).get();
    }

    public List<DbFile> getAllFiles(){
        return (List<DbFile>) filesRepository.findAll();
    }
}
