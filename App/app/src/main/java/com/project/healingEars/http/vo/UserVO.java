package com.project.healingEars.http.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserVO {
    public int userId;
    public String userType;
    public String userEmail;
    public String userPassword;
    public String userName;
    public String userSex;
    public String userBirth;
    public String userTel;
    public boolean userDel;
    public Date userCreateTimestamp;
    public Date userUpdateTimestamp;


    public UserVO(String userEmail, String userPassword) {
        System.out.println("UserVO 생성자 호출");
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}