package com.bhaktisudha.mvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bhaktisudha.mvpexample.Presenter.EnterPresenter;
import com.bhaktisudha.mvpexample.View.LoginView;

public class SecondActivity extends AppCompatActivity implements LoginView {
    EditText uid;
    EditText pwd;
    Button login;
    EnterPresenter enterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        uid = (EditText)findViewById(R.id.uid);
        pwd = (EditText)findViewById(R.id.pwd);
        login = (Button)findViewById(R.id.btn);
        enterPresenter= new EnterPresenter(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                enterPresenter.onLogin(uid.getText().toString(),pwd.getText().toString());
            }
        });


    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
