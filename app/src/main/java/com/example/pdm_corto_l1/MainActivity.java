package com.example.pdm_corto_l1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private LinearLayout mP1,mP2,mP3,mP4,mP5,mP6,mP7,mP8,mP9;
    private TextView mC1,mC2,mC3,mC4,mC5,mC6,mC7,mC8,mC9;
    private EditText mUser,mCorreo;
    private Button msend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onLoadContent();
        onCLickContentLoad();

        msend.setOnClickListener(v->{
            Intent mIntent= new Intent(MainActivity.this,activity_send.class);
            mIntent.putExtra("p1",mC1.getText().toString());
            mIntent.putExtra("p2",mC2.getText().toString());
            mIntent.putExtra("p3",mC3.getText().toString());
            mIntent.putExtra("p4",mC4.getText().toString());
            mIntent.putExtra("p5",mC5.getText().toString());
            mIntent.putExtra("p6",mC6.getText().toString());
            mIntent.putExtra("p7",mC7.getText().toString());
            mIntent.putExtra("p8",mC8.getText().toString());
            mIntent.putExtra("p9",mC9.getText().toString());
            mIntent.putExtra("email",mCorreo.getText().toString());
            mIntent.putExtra("user",mUser.getText().toString());


            startActivity(mIntent);


        });


    }

    private void onCLickContentLoad(){
        onCLickContent(mP1,mC1);
        onCLickContent(mP2,mC2);
        onCLickContent(mP3,mC3);
        onCLickContent(mP4,mC4);
        onCLickContent(mP5,mC5);
        onCLickContent(mP6,mC6);
        onCLickContent(mP7,mC7);
        onCLickContent(mP8,mC8);
        onCLickContent(mP9,mC9);

    }

    private void onLoadContent(){
        mP1 = findViewById(R.id.tv_producto1);
        mP2 = findViewById(R.id.tv_producto2);
        mP3 = findViewById(R.id.tv_producto3);
        mP4 = findViewById(R.id.tv_producto4);
        mP5 = findViewById(R.id.tv_producto5);
        mP6 = findViewById(R.id.tv_producto6);
        mP7 = findViewById(R.id.tv_producto7);
        mP8 = findViewById(R.id.tv_producto8);
        mP9 = findViewById(R.id.tv_producto9);

        mC1 =findViewById(R.id.tv_count_1);
        mC2 =findViewById(R.id.tv_count_2);
        mC3 =findViewById(R.id.tv_count_3);
        mC4 =findViewById(R.id.tv_count_4);
        mC5 =findViewById(R.id.tv_count_5);
        mC6 =findViewById(R.id.tv_count_6);
        mC7 =findViewById(R.id.tv_count_7);
        mC8 =findViewById(R.id.tv_count_8);
        mC9 =findViewById(R.id.tv_count_9);

        mCorreo = findViewById(R.id.et_email);
        mUser = findViewById(R.id.et_email);
        msend = findViewById(R.id.bt_send);
    }

    private void onCLickContent(LinearLayout m , TextView n){
        m.setOnClickListener(v->{
            int numero = Integer.parseInt((String) n.getText()) + 1;
            n.setText(String.valueOf(numero));
        });
    }
}
