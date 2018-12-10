package com.example.asus.proj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        findViewById(R.id.btnMatch).setOnClickListener(this);
        findViewById(R.id.btnAccount).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId()){
            case R.id.btnMatch:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnAccount:
                startActivity(new Intent(this, AccountActivity.class));
                break;
            case R.id.btnExit:
                System.exit(1);
                break;

        }
    }
}
