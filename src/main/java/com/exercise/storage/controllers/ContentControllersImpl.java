package com.exercise.storage.controllers;

import com.exercise.storage.service.FilesService;
import com.exercise.storage.service.WebInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ContentControllersImpl implements ContentController {

    private final WebInfoService webInfoService;
    private final FilesService filesService;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        filesService.saveFile(file);
        return "success";
    }

    @Override
    public String webUpload(String source) throws IOException {
        webInfoService.saveWebInfo(source);
        return "success";
    }

}
