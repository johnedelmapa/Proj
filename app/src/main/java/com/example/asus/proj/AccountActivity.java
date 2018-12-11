package com.example.asus.proj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AccountActivity extends AppCompatActivity implements View.OnClickListener
{

    EditText userName, password, cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        bind();
    }

    public void bind()
    {
        findViewById(R.id.btnExit).setOnClickListener(this);
        findViewById(R.id.btnAppend).setOnClickListener(this);
        userName = (EditText) findViewById(R.id.etNewName);
        password = (EditText) findViewById(R.id.etNewPassword);
        cpassword = (EditText) findViewById(R.id.etCPassword);

    }

    public void append()
    {
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String newUser  = userName.getText().toString();
        String newPassword = password.getText().toString();
        String cPassword = cpassword.getText().toString();

        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";


        if(newUser.isEmpty()) {
            userName.setError("Username is required");
            userName.requestFocus();
            return;
        }

        if(newUser.length()<4) {
            userName.setError("Username must be 4 characters");
            userName.requestFocus();
            return;
        }

        if(newPassword.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if(newPassword.length()<6) {
            password.setError("Password must be 6 characters");
            password.requestFocus();
            return;
        }


        if(!cPassword.equals(newPassword)) {
            cpassword.setError("Password does not match");
            cpassword.requestFocus();
            return;
        }






        SharedPreferences.Editor editor = preferences.edit();
        //stores 2 new instances of sharedprefs. Both the user and password's keys are the same as the input.
        editor.putString(newUser,newUser);
        editor.commit();
        editor.putString(newPassword, newPassword);
        editor.commit();
        editor.putString(newUser + newPassword + "data", newUser);
        editor.commit();

        Toast.makeText(AccountActivity.this, "Account Successfully Registered", Toast.LENGTH_SHORT).show();

        Intent loginActivity = new Intent(AccountActivity.this, LoginActivity.class);
        startActivity(loginActivity);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId()){
            case R.id.btnAppend:
                append();
                break;
            case R.id.btnExit:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
