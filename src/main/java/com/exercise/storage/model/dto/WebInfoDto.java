package com.exercise.storage.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class WebInfoDto implements Serializable {

    private Long id;
    private String name;
    private String url;
}
