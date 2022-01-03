package com.exercise.storage.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

public interface FilesListController {
    @GetMapping(value = "/fileslist")
    public ModelAndView filesList();

    @GetMapping("/fileslist/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) throws IOException;
}
