package com.example.fristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fristapp.util.DateUtil;


public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= findViewById(R.id.acti2);
        tv_result = findViewById(R.id.tvResult);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    public void doClick(View v){
        // 工具方法
        String desc = String.format("您点击了按钮：%s,现在的时间为 %s",((Button) v).getText(),DateUtil.getNowTime());
        tv_result.setText(desc);

    }

}