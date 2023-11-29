package com.example.expoin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bt_kr;
    private Button bt_jp;
    private Button bt_th;
    private Button bt_us;
    private Button bt_eu;
    private Button btn_ok;
    //각 버튼에 대한 변수

    private double result;
    private double kor = 1;
    private double jpn = 2;
    private double thn = 3;
    private double uts = 4;
    private double eun = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_kr = (Button)findViewById(R.id.bt_kr);

        bt_kr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = kor;

            }
        }); //한국 버튼이 눌리면 result의 변수값이 1로 변함

        bt_jp = (Button)findViewById(R.id.bt_jp);

        bt_jp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = jpn;

            }
        }); //일본 버튼이 눌리면 result의 변수값이 2로 변함

        bt_th = (Button)findViewById(R.id.bt_th);

        bt_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = thn;

            }
        }); //태국 버튼이 눌리면 result의 변수값이 3로 변함

        bt_us = (Button)findViewById(R.id.bt_us);

        bt_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = uts;

            }
        }); //미국 버튼이 눌리면 result의 변수값이 4로 변함

        bt_eu = (Button)findViewById(R.id.bt_eu);

        bt_eu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = eun;

            }
        }); //유럽 버튼이 눌리면 result의 변수값이 5로 변함


        btn_ok = (Button)findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(result == kor)
                {
                    Intent intent = new Intent(MainActivity.this , korea_coin.class);
                    startActivity(intent);
                } // 한국 버튼을 누르고 확인 버튼을 누르면 한국 동전에 관한 activity로 이동
                else
                {
                    Toast.makeText(getApplicationContext(), "다시 선택해 주세요", Toast.LENGTH_LONG).show();
                } // 한국이 아닌 다른 나라의 버튼을 누르고 확인 버튼을 누르면 다시 선택해 달라는 문구가 뜨도록 함
            }
        });
    }
    public void onBackPressed(){
        ActivityCompat.finishAffinity(MainActivity.this);
        System.exit(0);
    }
}