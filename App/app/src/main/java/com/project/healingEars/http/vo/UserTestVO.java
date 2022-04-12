package com.project.healingEars.http.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTestVO {
    public String result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public UserVO user;
}
