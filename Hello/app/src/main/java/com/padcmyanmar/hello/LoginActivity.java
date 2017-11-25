package com.padcmyanmar.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

/*
 * Created by User on 11/5/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL="aaa";
    private static final String CORRECT_PASSWORD="aaa";//Constant Attribute

    public static Intent newIntent(Context context){
        Intent  intent = new Intent(context,LoginActivity.class);
        return intent;
    }

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgetPassword;
    private TextView btnNewSeller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);

        btnLogin= findViewById(R.id.btn_login);
        etEmailOrPhone= findViewById(R.id.et_email_or_phone);
        etPassword= findViewById(R.id.et_password);
        btnForgetPassword= findViewById(R.id.btn_forget_pw);
        btnNewSeller= findViewById(R.id.btn_New_Seller);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Hello", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Action", null).show();
               String emailOrPhone = etEmailOrPhone.getText().toString();
               String password= etPassword.getText().toString();
               if(TextUtils.isEmpty(emailOrPhone)){
                   etEmailOrPhone.setError("Email Or Phone cannot be empty.");
                   return;
               }
               if(TextUtils.isEmpty(password)){
                   etEmailOrPhone.setError("password cannot be empty.");
                   return;
               }
               if((TextUtils.equals(emailOrPhone,CORRECT_EMAIL))&&(TextUtils.equals(password,CORRECT_PASSWORD))){
                    //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    Intent intent=HelloActivity.newIntent(getApplicationContext());
                    startActivity(intent);
               }else{
                   Snackbar.make(v,"Incorrect Please Try Again",Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();
               }

            }
        });

        btnForgetPassword.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Snackbar.make(v, "\"ForgetPassWord\" is Coming Soon", Snackbar.LENGTH_INDEFINITE)
                      .setAction("Action", null).show();
            }
        });

        btnNewSeller.setOnClickListener(new View.OnClickListener()

            {
                public void onClick (View v){
                       // Snackbar.make(v, "Registration is Comming Soon", Snackbar.LENGTH_INDEFINITE)
                      //.setAction("Action", null).show();
                    Intent intent=RegistrationActivity.newIntent(getApplicationContext());
                    startActivity(intent);
            }
            });
    }}


