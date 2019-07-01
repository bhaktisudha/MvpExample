package com.bhaktisudha.mvpexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bhaktisudha.mvpexample.Model.SignInPresenterImplementation;
import com.bhaktisudha.mvpexample.Presenter.SignInPresenter;
import com.bhaktisudha.mvpexample.View.SignInView;

public class MainActivity extends AppCompatActivity implements SignInView {
    SignInPresenter signInPresenter;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
Button mainBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBtn = (Button)findViewById(R.id.loginbtn);
        signInPresenter = new SignInPresenterImplementation(MainActivity.this);
        sharedPreferences.edit();
        signInPresenter.signin("Bhakti","bhakti");

        sharedPreferences = getSharedPreferences("MVPSharedPref",MODE_PRIVATE);
        editor.putString("KeyUname","Bhakti");
        editor.putString("KeyUpwd","Sudha");
        editor.apply();
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
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
