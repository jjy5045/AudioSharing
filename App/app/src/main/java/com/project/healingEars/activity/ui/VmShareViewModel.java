package com.project.healingEars.activity.ui;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.healingEars.http.dto.SessionDTO;
import com.project.healingEars.http.dto.StationDTO;
import com.project.healingEars.http.dto.UserDTO;
import com.project.healingEars.http.service.StationService;
import com.project.healingEars.http.service.UserService;
import com.project.healingEars.http.vo.StationListVO;
import com.project.healingEars.http.vo.UserVO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class VmShareViewModel extends ViewModel {
    public MutableLiveData<String> userNickName;
    public MutableLiveData<String> session;
    public MutableLiveData<String> loginState;
    public MutableLiveData<String> mText;

    public MutableLiveData<UserVO> userVO;
    public MutableLiveData<List<StationListVO>> stationListVO;
    //public List<StationListVO> stationListVO;

    public VmShareViewModel() {
        userVO = new MutableLiveData<>();
        mText = new MutableLiveData<>();
        userNickName = new MutableLiveData<>();
        session = new MutableLiveData<>();
        loginState = new MutableLiveData<>();
        stationListVO = new MutableLiveData<>();

        UserVO user = new UserVO("로그인 해주세요");
        userVO.setValue(user);
        session.setValue("초기값");
        mText.setValue("로그인실패");
        userNickName.setValue("Android Studio");
        loginState.setValue("LOGOUT");
    }

    public void Login(String userId, String userPassword) {
        try {
            Response<UserDTO> result = new UserService.LoginTask().execute(userId, userPassword).get();

            if ((result.body().result).equals("SUCCESS")) {
                mText.setValue("로그인성공");
                userVO.setValue(result.body().user);
                userNickName.setValue(userVO.getValue().userEmail);
                loginState.setValue("LOGIN");
            } else if ((result.body().result).equals("FAIL")) {
                mText.setValue("로그인실패");
            } else {
                mText.setValue("오류");
            }
        } catch (Exception ignored) {
            mText.setValue("서버오류");
        }
    }

    public void Logout() {
        try {
            String result = new UserService.Logout().execute().get();

            if(result.equals("SUCCESS")){
                UserVO user = new UserVO("로그인이 필요합니다.");
                userVO.setValue(user);
                mText.setValue("로그아웃 성공");
                loginState.setValue("LOGOUT");
            } else if (result.equals("FAIL")) {
                mText.setValue("로그아웃 실패");
                //loginState.setValue("LOGIN");
                //loginResult.setValue("로그아웃 실패");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SessionInfo() {
        try {
            Response<SessionDTO> result = new UserService.SessionInfo().execute().get();

            if ((result.body().loginState).equals("OK")) {
                session.setValue(result.body().sessionGetID);
            } else if((result.body().loginState).equals("FAIL")){
                session.setValue("로그인 상태 아님");
            } else {
                session.setValue("몰라");
            }
        } catch (Exception ignored) {
            session.setValue("에러");
        }
    }


    public void getStationList() {
        try {
            Response<StationDTO> result = new StationService.getAllStation().execute().get();

            if((result.body().result).equals("SUCCESS")) {
                stationListVO.setValue(result.body().station);
            } else
                mText.setValue("에러");
        } catch (Exception ignored) {
            mText.setValue("에러");
        }
    }

    public LiveData<String> getmText() { return mText; }

    public LiveData<String> getUserNickName() {
        return userNickName;
    }

    public MutableLiveData<UserVO> getUserVO() { return userVO; }

   // public List<StationListVO> getStation() { return (List)stationListVO.getValue(); }
}
