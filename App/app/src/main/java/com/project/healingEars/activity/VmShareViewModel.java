package com.project.healingEars.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.healingEars.http.dto.SessionDTO;
import com.project.healingEars.http.dto.UserDTO;
import com.project.healingEars.http.service.UserService;
import com.project.healingEars.http.vo.UserVO;

import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class VmShareViewModel extends ViewModel {
    public MutableLiveData<String> mText;
    public MutableLiveData<String> userNickName;
    public MutableLiveData<UserVO> userVO;
    public MutableLiveData<String> session;
    public MutableLiveData<String> loginState;


    public VmShareViewModel() {
        userVO = new MutableLiveData<>();
        mText = new MutableLiveData<>();
        userNickName = new MutableLiveData<>();
        session = new MutableLiveData<>();
        loginState = new MutableLiveData<>();

        UserVO user = new UserVO("로그인 해주세요");
        userVO.setValue(user);
        session.setValue("초기값");
        mText.setValue("This is home fragment");
        userNickName.setValue("Android Studio");
        loginState.setValue("OFF");
    }

    public void Login(String userId, String userPassword) {
        try {
            Response<UserDTO> result = new UserService.LoginTask().execute(userId, userPassword).get();

            if ((result.body().result).equals("SUCCESS")) {
                mText.setValue("로그인성공");
                userVO.setValue(result.body().user);
                userNickName.setValue(userVO.getValue().userEmail);
                loginState.setValue("ON");
            } else if ((result.body().result).equals("FAIL")) {
                mText.setValue("로그인실패");
            } else {
                mText.setValue("오류");
            }
        } catch (Exception ignored) {
            mText.setValue("통신 오류");
        }
    }

    public void Logout() {
        try {
            String result = new UserService.Logout().execute().get();

            if(result.equals("SUCCESS")){
                UserVO user = new UserVO("로그인이 필요합니다.");
                userVO.setValue(user);
                mText.setValue("로그아웃 성공");
                loginState.setValue("OFF");
            } else if (result.equals("FAIL")) {
                mText.setValue("로그아웃 실패");
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


    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getUserNickName() {
        return userNickName;
    }
}
