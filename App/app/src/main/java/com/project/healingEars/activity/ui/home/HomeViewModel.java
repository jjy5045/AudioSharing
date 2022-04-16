package com.project.healingEars.activity.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.healingEars.http.service.UserService;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public void Login(String userId, String userPassword) {
        try{
            String result = new UserService.LoginTask().execute(userId, userPassword).get();

            if(result.equals("SUCCESS")) {
                mText.setValue("로그인성공");
            } else if(result.equals("FAIL")) {
                mText.setValue("로그인실패");
            }
        }
        catch (Exception ignored) {
        }
    }

    public LiveData<String> getText() {
        return mText;
    }
}