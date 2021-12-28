package com.exercise.storage.controllers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HomeControllerImpl implements HomeController{

    @Override
    public String home() {
        return "index";
    }

}
