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
    TextView result1;

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
        result1 = (TextView) findViewById(R.id.tvResult);
        findViewById(R.id.btnAdd).setOnClickListener(this);
    }

    public void Add()
    {
        Double one = Double.parseDouble(firstNum.getText().toString());
        Double two = Double.parseDouble(secondNum.getText().toString());
        Double result = one + two;
        result1.setText(Double.toString(result));
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
