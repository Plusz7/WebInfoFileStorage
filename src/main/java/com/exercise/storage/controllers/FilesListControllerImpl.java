package com.exercise.storage.controllers;

import com.exercise.storage.model.persistent.DbFile;
import com.exercise.storage.service.FilesService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class FilesListControllerImpl implements FilesListController {

    private final FilesService filesService;

    @Override
    public ModelAndView filesList() {
        List<DbFile> list = filesService.getAllFiles();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileslist");
        modelAndView.addObject("file", list);
        return modelAndView;
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(String id) {
        DbFile file = filesService.getFile(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(file.getContent());
    }
}
