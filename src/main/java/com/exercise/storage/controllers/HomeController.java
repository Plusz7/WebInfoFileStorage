package com.exercise.storage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface HomeController {

    @GetMapping("/")
    public String home();
}
