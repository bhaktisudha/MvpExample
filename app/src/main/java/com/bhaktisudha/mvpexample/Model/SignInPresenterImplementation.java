package com.bhaktisudha.mvpexample.Model;

import android.text.TextUtils;

import com.bhaktisudha.mvpexample.Presenter.SignInPresenter;
import com.bhaktisudha.mvpexample.View.SignInView;

public class SignInPresenterImplementation implements SignInPresenter {

    private SignInView signInView;

    public SignInPresenterImplementation(SignInView signInView) {
        this.signInView = signInView;
    }

    @Override
    public void signin(String userId, String pwd) {

        if(TextUtils.isEmpty(userId) || TextUtils.isEmpty(pwd)){
           signInView.validationError();
        }else {
            if(userId.equalsIgnoreCase("Bhakti") && pwd.equalsIgnoreCase("bhakti"))
            {
               signInView.loginSucees();
            }else {
                signInView.loginError();
            }

        }

    }
}
