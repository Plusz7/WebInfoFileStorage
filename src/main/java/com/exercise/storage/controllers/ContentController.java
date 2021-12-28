package com.exercise.storage.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ContentController {

    @PostMapping("/uploadfile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException;

    @PostMapping("/webupload")
    public String webUpload(@RequestParam("webinfo") String source) throws IOException;

}
