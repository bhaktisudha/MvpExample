package com.bhaktisudha.mvpexample.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class EnterClass implements EnterInter{

    String email,password;

    public EnterClass(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPwd() {
        return password;
    }

    @Override
    public boolean validate() {
        return TextUtils.isEmpty(getEmail())&&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPwd().length()>6;
    }
}
