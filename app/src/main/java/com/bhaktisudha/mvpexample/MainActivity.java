package com.bhaktisudha.mvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bhaktisudha.mvpexample.Model.SignInPresenterImplementation;
import com.bhaktisudha.mvpexample.Presenter.SignInPresenter;
import com.bhaktisudha.mvpexample.View.SignInView;

public class MainActivity extends AppCompatActivity implements SignInView {
    SignInPresenter signInPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInPresenter = new SignInPresenterImplementation(MainActivity.this);
        signInPresenter.signin("Bhakti","bhakti");
    }

    @Override
    public void validationError() {
        Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucees() {
        Toast.makeText(MainActivity.this,"Sucess",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
    }
}
