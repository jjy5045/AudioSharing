package com.project.healingEars.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.healingEars.http.service.UserService;

public class VmShareViewModel extends ViewModel {
    public MutableLiveData<String> mText;
    public MutableLiveData<String> userNickName;

    public VmShareViewModel() {
        mText = new MutableLiveData<>();
        userNickName = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        userNickName.setValue("Android Studio");
    }

    public void Login(String userId, String userPassword) {
        try{
            String result = new UserService.LoginTask().execute(userId, userPassword).get();

            if(result.equals("SUCCESS")) {
                mText.setValue("로그인성공");
                userNickName.setValue("로그인 완료");
            } else if(result.equals("FAIL")) {
                mText.setValue("로그인실패");
            } else
            {
                mText.setValue("오류");
            }
        }
        catch (Exception ignored) {
            mText.setValue("통신 오류");
        }
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getUserNickName() { return  userNickName; }
}
