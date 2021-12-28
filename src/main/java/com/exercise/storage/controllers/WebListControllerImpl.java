package com.exercise.storage.controllers;

import com.exercise.storage.model.persistent.DbWebInfo;
import com.exercise.storage.service.WebInfoService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
        Optional<DbWebInfo> webInfo = webInfoService.findWebInfo(id);
        if(webInfo.isPresent()){
            File file = new File(webInfo.get().getName());
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file)); // try/catch with resources TODO
            bufferedWriter.write(Jsoup.connect(webInfo.get().getUrl()).get().html());
            bufferedWriter.close();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
        }
        return null;
    }
}
