package com.project.healingEars.http.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class test2VO {

    public String result;
    @JsonProperty("UserVO")
    public UserVO userVO;

    public class UserVO{
        public int userId;
        public String userType;
        public String userEmail;
        public String userName;
        public String userSex;
        public String userBirth;
        public String userTel;
        public String userPassword;
        public boolean userDel;
        public Date userCreateTimestamp;
        public Date userUpdateTimestamp;
    }
}
