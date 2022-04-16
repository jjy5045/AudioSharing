package com.project.healingEars.activity.ui.gallery;

import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.snackbar.Snackbar;
import com.project.healingEars.activity.HomeActivity;
import com.project.healingEars.activity.LoginActivity;
import com.project.healingEars.api.preference.CookieSharedPreference;
import com.project.healingEars.http.service.UserService;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }


    public LiveData<String> getText() {
        return mText;
    }
}