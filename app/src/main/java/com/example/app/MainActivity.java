package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button mRegisterButton;//注册按钮
    private Button mLoginButton;//登录按钮

    private EditText mUser;
    private EditText mKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser=(EditText)findViewById(R.id.name);
        mKey=(EditText)findViewById(R.id.password);
        mRegisterButton=(Button)findViewById(R.id.button2);
        mLoginButton=(Button)findViewById(R.id.button);


        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)  //给登录按钮设置监听器
            {
                String username = mUser.getText().toString();
                String userpassword = mKey.getText().toString();
                Intent data= getIntent();

                String username1=data.getStringExtra("userName");//获取注册值
                String userpassword1=data.getStringExtra("password");//获取注册值

                //if(!username.equals(username1))//验证
                //{Toast.makeText(MainActivity.this, username1,
                // Toast.LENGTH_SHORT).show();}


                if(TextUtils.isEmpty(username)||TextUtils.isEmpty(userpassword)){
                    Toast.makeText(MainActivity.this,"账号或者密码不能为空",
                            Toast.LENGTH_SHORT).show();
                }
//
                if(username.equals(username1)&&userpassword.equals(userpassword1)) {
                    Toast.makeText(MainActivity.this,"欢迎登录！",
                            Toast.LENGTH_SHORT).show();//事件触发,显示欢迎信息
                    //下面跳转问卷界面
                    Intent intent1 = new Intent();
                    intent1.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent1);//跳转注册界面
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"登录失败！",
                            Toast.LENGTH_SHORT).show();//事件触发,显示登录失败
                }

            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity3.class);
                startActivity(intent);//跳转注册界面
                finish();
            }
        });
    }
}