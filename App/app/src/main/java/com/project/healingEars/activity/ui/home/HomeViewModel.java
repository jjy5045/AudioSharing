package com.project.healingEars.activity.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.healingEars.http.service.UserService;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<String> mText;
    public MutableLiveData<String> userNickName;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        userNickName = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        userNickName.setValue("Android Studio");
    }


    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getUserNickName() { return  userNickName; }
}