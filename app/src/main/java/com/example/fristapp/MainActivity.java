package com.example.fristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fristapp.util.DateUtil;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private static TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取id button 不是全局 tv_result 需要在内部方法/类中使用，所以设置全局变量
        Button button= findViewById(R.id.acti2);
        Button getTime_priv = findViewById(R.id.getTime_priv);
        Button getTime_pub = findViewById(R.id.getTime_pub);
        tv_result = findViewById(R.id.tvResult);

        // Click事件 第一种写法
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        // 传递实例 第二种标准写法，使用内部类
        getTime_priv.setOnClickListener(new MyOnClickListener(tv_result));

        // 第三种 此类建立建立 View.OnClickListener 的接口实现，所有Button都可以访问
        getTime_pub.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.getTime_pub) {
            String desc = String.format("您点击了按钮：%s，现在的时间为 %s", ((Button) v).getText(), DateUtil.getNowTime());
            tv_result.setText(desc);
        }
    }

    //内部类
    static class MyOnClickListener implements View.OnClickListener{
        private final TextView tv_result;

        public MyOnClickListener(TextView tv_result) {
            this.tv_result = tv_result;
        }

        @Override
        public void onClick(View v){
            String desc = String.format("您点击了按钮：%s，现在的时间为 %s",((Button) v).getText(),DateUtil.getNowTime());
            tv_result.setText(desc);
        };

    }


}