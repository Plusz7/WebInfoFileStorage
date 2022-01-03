package com.exercise.storage.controllers;

import com.exercise.storage.model.persistent.DbWebInfo;
import com.exercise.storage.service.WebInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebListControllerImpl implements WebListController {

    private final WebInfoService webInfoService;

    @Override
    public ModelAndView webInfoList() {

        List<DbWebInfo> list = webInfoService.getWebInfoList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("weblist");
        modelAndView.addObject("allWebinfo", list);
        return modelAndView;
    }

    @Override
    public ResponseEntity<Resource> pageSourceToFile(String id) throws IOException {
        DbWebInfo webInfo = webInfoService.findWebInfo(id);
        InputStreamResource resource = webInfoService.collectResource(webInfo);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }
}
