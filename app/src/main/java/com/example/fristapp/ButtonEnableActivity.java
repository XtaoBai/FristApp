package com.example.fristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fristapp.util.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonTest;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        Button buttonEnable = findViewById(R.id.buttonEnable);
        Button buttonDisable = findViewById(R.id.buttonDisable);
        buttonTest = findViewById(R.id.buttonTest);
        tvResult = findViewById(R.id.tvResult);

        buttonEnable.setOnClickListener(this);
        buttonDisable.setOnClickListener(this);
        buttonTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonEnable:
                // 启用当前控件
                buttonTest.setEnabled(true);
                buttonTest.setTextColor(Color.BLACK);
                break;
            case R.id.buttonDisable:
                //  禁用当前控件
                buttonTest.setEnabled(false);
                buttonTest.setTextColor(Color.GRAY);
                break;
            case R.id.buttonTest:
                String desc = String.format("您点击了按钮：%s，现在的时间为 %s",((Button) view).getText(), DateUtil.getNowTime());
                tvResult.setText(desc);
                break;
        }
    }
}