package com.example.expoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class korea_coin extends AppCompatActivity {

    private EditText in500;
    private EditText in100;
    private EditText in50;
    private EditText in10;
    private EditText in_value;
    private Button btn_ch;

    private int value; //내야할 금액 입력 변수
    private int i500; //500원 개수 입력 변수
    private int i100; //100원 개수 입력 변수
    private int i50; //50원 개수 입력 변수
    private int i10; //10원 개수 입력 변수
    private int coinsum; //소지한 금액의 총합
    private int result; //coinsum-value의 값
    private int um500; //지불해야할 500원 개수
    private String mm500; //지불해야할 500원 개수 변수를 string으로 변환
    private int um100;
    private String mm100;
    private int um50;
    private String mm50;
    private int um10;
    private String mm10;
    private int amount;

    private int re500; //지불후 남은 500원 개수
    private String rm500; //지불후 남은 500원 개수 string으로 변환
    private int re100;
    private int pls100; //100원 거스름동 개수
    private String rm100;
    private int re50;
    private int pls50;
    private String rm50;
    private int re10;
    private int pls10;
    private String rm10;
    private int num;

    private String save500;
    private String save100;
    private String save50;
    private String save10;

    private String sf500 = "sf500"; //500원 개수 저장 파일
    private String sf100 = "sf100";
    private String sf50 = "sf50";
    private String sf10 = "sf10";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korea_coin);

        Intent intent = getIntent();

        in500 = (EditText) findViewById(R.id.in500);

        /*SharedPreferences sharedPreferences = getSharedPreferences(sf500, 0);
        String value500 = sharedPreferences.getString("key","");
        in500.setText(value500);*/

        save500 = intent.getStringExtra("rm500");
        in500.setText(save500);
        try{
            i500 = Integer.parseInt(in500.getText().toString());
        } catch (NumberFormatException e){
        } catch (Exception e){
        }
        in500.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    i500 = Integer.parseInt(in500.getText().toString());
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        }); //in500의 입력값을 i500에 넣어줌

        in100 = (EditText) findViewById(R.id.in100);
        save100 = intent.getStringExtra("rm100");
        in100.setText(save100);
        try{
            i100 = Integer.parseInt(in100.getText().toString());
        } catch (NumberFormatException e){
        } catch (Exception e){
        }
        in100.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    i100 = Integer.parseInt(in100.getText().toString());
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        }); //in100의 입력값을 i100에 넣어줌

        in50 = (EditText) findViewById(R.id.in50);
        save50 = intent.getStringExtra("rm50");
        in50.setText(save50);
        try{
            i50 = Integer.parseInt(in50.getText().toString());
        } catch (NumberFormatException e){
        } catch (Exception e){
        }
        in50.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    i50 = Integer.parseInt(in50.getText().toString());
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        }); //in50의 입력값을 i50에 넣어줌

        in10 = (EditText) findViewById(R.id.in10);
        save10 = intent.getStringExtra("rm10");
        in10.setText(save10);
        try{
            i10 = Integer.parseInt(in10.getText().toString());
        } catch (NumberFormatException e){
        } catch (Exception e){
        }
        in10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    i10 = Integer.parseInt(in10.getText().toString());
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        }); //in500의 입력값을 i500에 넣어줌


        in_value = (EditText) findViewById(R.id.in_value);
        in_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    value = Integer.parseInt(in_value.getText().toString());
                } catch (NumberFormatException e) {
                } catch (Exception e) {
                }
            }
        }); //in_value의 입력값을 value에 넣어줌


        btn_ch = (Button)findViewById(R.id.btn_ch);
        btn_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                coinsum = 500*i500 + 100*i100 + 50*i50 + 10*i10; //소지한 금액 계산
                result = coinsum - value;

                if(result < 0)
                {
                    if(value%10 > 0){
                        Toast.makeText(getApplicationContext(), "제대로 된 값을 입력해주세요", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "현재 소지한 금액으로 지불이 불가능 합니다. 다시 입력해주세요", Toast.LENGTH_LONG).show();
                    }
                }
                else if(result >= 0)
                {
                    if(value%10 > 0){
                        Toast.makeText(getApplicationContext(), "제대로 된 값을 입력해주세요", Toast.LENGTH_LONG).show();
                    }
                    else{
                        amount = value; //value는 입력받은 지불 해야할 값
                        //um500 = 내야할 500원의 개수
                        if(amount <= 500*i500){// 현재 소지한 500원의 금액이 지불 해야할 값보다 클경우
                            if(amount%500 > (100*i100+50*i50+10*i10)){
                                um500 = amount/500+1;

                                num = um500*500-amount;
                                pls100 = num/100;
                                num %= 100;
                                pls50 = num/50;
                                num %= 50;
                                pls10 = num/10;
                                //각 동전 거스름돈 계산

                                amount = 0;
                            }// 지불 해야할 값에 500을 나누었을 때 남은 금액을 현재 소지한 다른 동전으로 지불이 가능하지 않을 경우
                            else{
                                um500 = amount/500;
                                amount %= 500;
                            }
                        }
                        else{
                            um500 = i500;
                            amount -= 500*i500;
                        }
                        mm500 = String.valueOf(um500);
                        re500 = i500 - um500;
                        rm500 = String.valueOf(re500);

                        //um100 = 내야할 100원의 개수
                        if(amount <= 100*i100){// 500원을 뺀 현재 소지한 100원의 금액이 지불 해야할 값보다 클경우
                            if(amount%100 > (50*i50+10*i10)){
                                um100 = amount/100+1;

                                num = um100*100-amount;
                                pls50 = num/50;
                                num %= 50;
                                pls10 = num/10;
                                //각 동전 거스름돈 계산

                                amount = 0;
                            }// 지불 해야할 값에 100을 나누었을 때 남은 금액을 현재 소지한 다른 동전으로 지불이 가능하지 않을 경우
                            else{
                                um100 = amount/100;
                                amount %= 100;
                            }
                        }
                        else{
                            um100 = i100;
                            amount -= 100*i100;
                        }
                        mm100 = String.valueOf(um100);
                        re100 = i100 - um100 + pls100; //pls100으로 100원짜리로 받을 거스름돈의 개수도 더해줌
                        rm100 = String.valueOf(re100);

                        //um50 = 내야할 50원의 개수
                        if(amount <= 50*i50){// 500,100원을 뺀 현재 소지한 50원의 금액이 지불 해야할 값보다 클경우
                            if(amount%50 > (10*i10)){
                                um50 = amount/50+1;

                                num = um50*50-amount;
                                pls10 = num/10;
                                //각 동전 거스름돈 계산

                                amount = 0;
                            }// 지불 해야할 값에 50을 나누었을 때 남은 금액을 현재 소지한 다른 동전으로 지불이 가능하지 않을 경우
                            else{
                                um50 = amount/50;
                                amount %= 50;
                            }
                        }
                        else{
                            um50 = i50;
                            amount -= 50*i50;
                        }
                        mm50 = String.valueOf(um50);
                        re50 = i50 - um50 + pls50; //pls50으로 50원짜리로 받을 거스름돈의 개수도 더해줌
                        rm50 = String.valueOf(re50);

                        //um10 = 내야할 10원의 개수
                        if(amount <= 10*i10){// 500,100,50원을 뺀 현재 소지한 10원의 금액이 지불 해야할 값보다 클경우
                            um10 = amount/10;
                        }
                        else{
                            um10 = i10;
                        }
                        mm10 = String.valueOf(um10);
                        re10 = i10 - um10 + pls10; //pls10으로 10원짜리로 받을 거스름돈의 개수도 더해줌
                        rm10 = String.valueOf(re10);

                        Intent intent = new Intent(korea_coin.this , coin_pay.class);
                        intent.putExtra("ip500", mm500);
                        intent.putExtra("ip100", mm100);
                        intent.putExtra("ip50", mm50);
                        intent.putExtra("ip10", mm10);
                        intent.putExtra("rm500", rm500);
                        intent.putExtra("rm100", rm100);
                        intent.putExtra("rm50", rm50);
                        intent.putExtra("rm10", rm10);
                        startActivity(intent);
                    } //지불이 가능하면 지불할 동전 개수 출력 화면으로 넘어감
                } // 한국이 아닌 다른 나라의 버튼을 누르고 확인 버튼을 누르면 다시 선택해 달라는 문구가 뜨도록 함
            }
        });
    }
   /* protected void onStop() {
        super.onStop();
        // Activity 가 종료되기 전에 저장한다
        SharedPreferences  sharedPreferences = getSharedPreferences(sf500, 0);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        String value500 = in500.getText().toString();
        editor.putString("key", value500);
        editor.commit();
    }*/

    public void onBackPressed(){
        Intent intent = new Intent(korea_coin.this, MainActivity.class);
        startActivity(intent);
    }
}