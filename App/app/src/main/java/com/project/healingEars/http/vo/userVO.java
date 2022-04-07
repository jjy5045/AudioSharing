package com.project.healingEars.http.vo;

public class userVO {
    private String userId;
    private String userBirth;
    private String userCreateTimestamp;
    private String userEmail;
    private String userName;
    private String userPassword;
    private String userSex;
    private String userTel;
    private String userType;
    private String userUpdateTimestamp;

    //생성자
    public userVO() {
        System.out.println("UserVO 생성자 호출");
    }

    public userVO(String userId, String userBirth, String userCreateTimestamp,
                  String userEmail, String userName, String userPassword,
                  String userSex, String userTel, String userType, String userUpdateTimestamp) {
        System.out.println("UserVO 생성자 호출");
        this.userId = userId;
        this.userBirth = userBirth;
        this.userCreateTimestamp = userCreateTimestamp;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userType = userType;
        this.userUpdateTimestamp = userUpdateTimestamp;
    }

    public userVO(String userEmail, String userPassword) {
        System.out.println("UserVO 생성자 호출");
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserCreateTimestamp() {
        return userCreateTimestamp;
    }

    public void setUserCreateTimestamp(String userCreateTimestamp) {
        this.userCreateTimestamp = userCreateTimestamp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserUpdateTimestamp() {
        return userUpdateTimestamp;
    }

    public void setUserUpdateTimestamp(String userUpdateTimestamp) {
        this.userUpdateTimestamp = userUpdateTimestamp;
    }

    @Override
    public String toString() {
        return "userVO{" +
                "userId='" + userId + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userCreateTimestamp='" + userCreateTimestamp + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userType='" + userType + '\'' +
                ", userUpdateTimestamp='" + userUpdateTimestamp + '\'' +
                '}';
    }
}
