package com.example.expoin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class remain_coin extends AppCompatActivity {

    private Button btn_end;
    private Button btn_save;
    private EditText out500;
    private EditText out100;
    private EditText out50;
    private EditText out10;
    private int ot500;
    private int ot100;
    private int ot50;
    private int ot10;

    private String re500;
    private String re100;
    private String re50;
    private String re10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remain_coin);

        Intent intent = getIntent();

        out500 = (EditText) findViewById(R.id.out500);
        re500 = intent.getStringExtra("rm500");
        out500.setText(re500);
        out500.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    ot500 = Integer.parseInt(out500.getText().toString());
                    re500 = String.valueOf(ot500);
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        });

        out100 = (EditText) findViewById(R.id.out100);
        re100 = intent.getStringExtra("rm100");
        out100.setText(re100);
        out100.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    ot100 = Integer.parseInt(out100.getText().toString());
                    re100 = String.valueOf(ot100);
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        });

        out50 = (EditText) findViewById(R.id.out50);
        re50 = intent.getStringExtra("rm50");
        out50.setText(re50);
        out50.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    ot50 = Integer.parseInt(out50.getText().toString());
                    re50 = String.valueOf(ot50);
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        });

        out10 = (EditText) findViewById(R.id.out10);
        re10 = intent.getStringExtra("rm10");
        out10.setText(re10);
        out10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    ot10 = Integer.parseInt(out10.getText().toString());
                    re10 = String.valueOf(ot10);
                } catch (NumberFormatException e){
                } catch (Exception e){
                }
            }
        });

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(remain_coin.this);
                builder.setMessage("동전 개수를 저장하시겠습니까?");
                builder.setTitle("저장 확인")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Intent intent = new Intent(remain_coin.this , korea_coin.class);
                                intent.putExtra("rm500", re500);
                                intent.putExtra("rm100", re100);
                                intent.putExtra("rm50", re50);
                                intent.putExtra("rm10", re10);
                                Toast.makeText(getApplicationContext(), "입력 화면으로 돌아갑니다.", Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("저장 확인");
                alert.show();
            }
        });

        btn_end = (Button) findViewById(R.id.btn_end);
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(remain_coin.this);
                builder.setMessage("정말 종료하시겠습니까?");
                builder.setTitle("종료 알림")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                ActivityCompat.finishAffinity(remain_coin.this);
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("종료 알림");
                alert.show();
            }
        }); //앱을 종료할 것인지 물어본 후 yes를 누르면 앱 종료.
    }
}
