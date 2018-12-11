package com.example.asus.proj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void bind ()
    {
        findViewById(R.id.btnMatch).setOnClickListener(this);
        findViewById(R.id.btnAccount).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
    }

    public void clear()
    {
        preferences.edit().clear().apply();
        Toast.makeText(MainActivity.this, "Successfully Cleared Shared Preferences", Toast.LENGTH_SHORT).show();
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
                onBackPressed();
                break;
            case R.id.btnClear:
                clear();
                break;
        }
    }
}
