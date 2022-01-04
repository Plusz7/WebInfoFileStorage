package com.exercise.storage.service;

import com.exercise.storage.model.persistent.DbFile;
import com.exercise.storage.repository.FilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilesServiceImpl implements FilesService {

    private final FilesRepository filesRepository;

    public void saveFile(MultipartFile file) throws IOException {
        DbFile dbFile = DbFile.builder()
                .name(file.getName())
                .content(file.getBytes())
                .size(String.valueOf(file.getSize()))
                .type(file.getContentType())
                .build();
        filesRepository.save(dbFile);
    }

    public DbFile getFile(String id) {
        Optional<DbFile> byId = filesRepository.findById(Long.valueOf(id));
        return byId.orElse(null);
    }

    public List<DbFile> getAllFiles() {
        return (List<DbFile>) filesRepository.findAll();
    }
}
