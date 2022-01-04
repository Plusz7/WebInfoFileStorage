package com.exercise.storage.service;

import com.exercise.storage.exceptions.DbFileNotFoundException;
import com.exercise.storage.model.persistent.DbFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FilesService {
    void saveFile(MultipartFile file) throws IOException;
    DbFile getFile(String id) throws DbFileNotFoundException;
    List<DbFile> getAllFiles();
}
