package com.bhaktisudha.mvpexample.Presenter;

import com.bhaktisudha.mvpexample.Model.EnterClass;
import com.bhaktisudha.mvpexample.View.LoginView;

public class EnterPresenter implements EnterPresenterInter {
     LoginView loginView;

    public EnterPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String emaai, String password) {
        EnterClass enterClass = new EnterClass(emaai,password);
        boolean isLoginSucess = enterClass.validate();

        if (isLoginSucess){
            loginView.onLoginResult("Loging Sucessfully...");
        }else {
            loginView.onLoginResult("Error....");
        }
    }
}
