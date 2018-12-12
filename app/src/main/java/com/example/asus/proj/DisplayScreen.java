package com.example.asus.proj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DisplayScreen extends AppCompatActivity implements View.OnClickListener {

    EditText firstNum, secondNum;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        bind();
        display();
    }

    public void display()
    {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", "");
        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(" Welcome "+display+"!");
    }
    public void bind(){
        firstNum = (EditText) findViewById(R.id.etFirstnum);
        secondNum = (EditText) findViewById(R.id.etSecondnum);
        result = (TextView) findViewById(R.id.tvResult);
        findViewById(R.id.btnAdd).setOnClickListener(this);
    }

    public void Add()
    {
        String stringOne = firstNum.getText().toString();
        String stringTwo = secondNum.getText().toString();

        if(stringOne.isEmpty()) {
            firstNum.setError("You must enter value one");
            firstNum.requestFocus();
            return;
        }

        if(stringTwo.isEmpty()) {
            secondNum.setError("You must enter value two");
            secondNum.requestFocus();
            return;
        }

        Double sum =  (Double.parseDouble(stringOne)) + (Double.parseDouble(stringTwo));
        result.setText(Double.toString(sum));
    }


    @Override
    public void onClick(View view)
    {
        switch(view.getId()){
            case R.id.btnAdd:
                Add();
                break;

        }
    }
}
