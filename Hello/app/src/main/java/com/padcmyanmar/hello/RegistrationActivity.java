package com.padcmyanmar.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 11/15/2017.
 */

public class RegistrationActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent  intent = new Intent(context,RegistrationActivity.class);
        return intent;
    }


    private Button btnRegrstration;
    private EditText etname;
    private EditText etemail;
    private EditText etphone;
    private EditText etaddress;
    private EditText etpassword;
    private EditText etconfirmpassword;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegrstration=findViewById(R.id.btn_registration);
        etname=findViewById(R.id.et_name);
        etemail=findViewById(R.id.et_email);
        etphone=findViewById(R.id.et_phone);
        etaddress=findViewById(R.id.et_address);
        etpassword=findViewById(R.id.et_password);
        etconfirmpassword=findViewById(R.id.et_confirm_password);

        btnRegrstration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                String email=etemail.getText().toString();
                String phone=etphone.getText().toString();
                String address=etaddress.getText().toString();
                String password=etpassword.getText().toString();
                String confirmpassword=etconfirmpassword.getText().toString();

                if(TextUtils.isEmpty(name)){
                    etname.setError("Please fill Name");
                    return;
                }

                if(TextUtils.isEmpty((phone))){
                    etphone.setError("Please fill Phone Number");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    etemail.setError("Please fill Email");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    etpassword.setError("Please fill password");
                    return;
                }
                if(TextUtils.isEmpty(confirmpassword)){
                    etconfirmpassword.setError("Plesae fill confirmpassword");
                    return;
                }
                if(TextUtils.equals(password,confirmpassword)==false){
                    etconfirmpassword.setError("Please type same passsword");
                    return;
                }
                if(TextUtils.isEmpty(address)){
                    etaddress.setError("Please fill Address");
                    return;
                }
                else{
                    Snackbar.make(v,"Success Registration",Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();
                    Intent intent=LoginActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }

            }
        });


    }

}
