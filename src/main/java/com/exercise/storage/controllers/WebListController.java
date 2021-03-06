package com.exercise.storage.controllers;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

public interface WebListController {

    @GetMapping(value = "/webinfolist")
    public ModelAndView webInfoList();

    @GetMapping("/webinfolist/{id}")
    public ResponseEntity<Resource> pageSourceToFile(@PathVariable String id) throws IOException;
}
