package com.nonglam.baobaoshopadmin.ui;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nonglam.baobaoshopadmin.API.APIServices;
import com.nonglam.baobaoshopadmin.MainActivity;
import com.nonglam.baobaoshopadmin.R;
import com.nonglam.baobaoshopadmin.databinding.ActivityLoginBinding;
import com.nonglam.baobaoshopadmin.model.User;
import com.nonglam.baobaoshopadmin.static_data.DataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        boolean result = false;




        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                APIServices.apiServices.login(new User(usernameEditText.getText().toString(),passwordEditText.getText().toString()))
                        .enqueue(new
                                         Callback<User>() {
                                             @Override
                                             public void onResponse(Call<User> call, Response<User> response) {
                                                 try{
                                                     User user = response.body();
                                                     DataSource.token= user.getToken();
                                                     MainActivity.sqLite.queryData("INSERT INTO TOKEN VALUES(\""+DataSource.token+"\")");
                                                     switchScreen();



                                                     Toast.makeText(getApplicationContext(), "Đăng nhập thành công",
                                                             Toast.LENGTH_LONG).show();
                                                 } catch(Exception e) {
                                                     Toast.makeText(getApplicationContext(), "Đăng nhập thất bại, hãy kiểm tra lại",
                                                             Toast.LENGTH_LONG).show();
                                                 }
                                             }
                                             @Override
                                             public void onFailure(Call<User> call, Throwable t) {
                                                 Toast.makeText(getApplicationContext(), "Đăng nhập thất bại,hãy kiểm tra lại",
                                                         Toast.LENGTH_LONG).show();
                                             }
                                         }
                        );

            }
        });
    }
    private void switchScreen(){
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }


}