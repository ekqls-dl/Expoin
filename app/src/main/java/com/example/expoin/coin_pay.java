package com.example.expoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class coin_pay extends AppCompatActivity {

    private Button btn_comp;
    private String ip500;
    private String ip100;
    private String ip50;
    private String ip10;
    private TextView out500;
    private TextView out100;
    private TextView out50;
    private TextView out10;

    private String rm500;
    private String rm100;
    private String rm50;
    private String rm10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_pay);

        Intent intent = getIntent();

        ip500 = intent.getStringExtra("ip500");
        out500 = (TextView) findViewById(R.id.out500);
        out500.setTextSize(35);
        out500.setText(ip500);
        rm500 = intent.getStringExtra("rm500");

        ip100 = intent.getStringExtra("ip100");
        out100 = (TextView) findViewById(R.id.out100);
        out100.setTextSize(35);
        out100.setText(ip100);
        rm100 = intent.getStringExtra("rm100");

        ip50 = intent.getStringExtra("ip50");
        out50 = (TextView) findViewById(R.id.out50);
        out50.setTextSize(35);
        out50.setText(ip50);
        rm50 = intent.getStringExtra("rm50");

        ip10 = intent.getStringExtra("ip10");
        out10 = (TextView) findViewById(R.id.out10);
        out10.setTextSize(35);
        out10.setText(ip10);
        rm10 = intent.getStringExtra("rm10");

        btn_comp = (Button) findViewById(R.id.btn_comp);
        btn_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coin_pay.this , remain_coin.class);
                intent.putExtra("rm500", rm500);
                intent.putExtra("rm100", rm100);
                intent.putExtra("rm50", rm50);
                intent.putExtra("rm10", rm10);
                startActivity(intent);
            }
        });
    }

}