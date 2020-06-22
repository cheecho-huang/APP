package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText mUser;
    private EditText mKey;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn = (Button)findViewById(R.id.button);
        mUser = (EditText)findViewById(R.id.username);
        mKey = (EditText)findViewById(R.id.password);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)  //给登录按钮设置监听器
            {
                String username = mUser.getText().toString();
                String userpassword = mKey.getText().toString();
                Intent data= getIntent();

                String username1=data.getStringExtra("username");//获取注册值
                String userpassword1=data.getStringExtra("userpassword");//获取注册值

                //if(!username.equals(username1))//验证
                //{Toast.makeText(MainActivity.this, username1,
                // Toast.LENGTH_SHORT).show();}


                if(TextUtils.isEmpty(username)||TextUtils.isEmpty(userpassword)){
                    Toast.makeText(MainActivity3.this,"账号或者密码不能为空",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity3.this, "注册成功", Toast.LENGTH_SHORT).show();
                    // 返回值到loginActivity显示
                    Intent data1 = new Intent();
                    data1.putExtra("userName", username);
                    data1.putExtra("password",userpassword);
                    setResult(RESULT_OK, data1);
                    data1.setClass(MainActivity3.this, MainActivity.class);
                    //RESULT_OK为Activity系统常量，状态码为-1，
                    startActivity(data1);
                    MainActivity3.this.finish();
                }

            }
        });

}}