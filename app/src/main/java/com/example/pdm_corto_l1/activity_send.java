package com.example.pdm_corto_l1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_send extends AppCompatActivity {

    private TextView mC1,mC2,mC3,mC4,mC5,mC6,mC7,mC8,mC9,mTotal, mUser,mCorreo;
    private Button mSend;
    private int contador;
    private String factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        onLoadContent();
        Intent mIntent = getIntent();
        if (mIntent!=null){
            mUser.setText(mIntent.getStringExtra("user"));
            mCorreo.setText(mIntent.getStringExtra("email"));
            mC1.setText(mIntent.getStringExtra("p1"));
            mC2.setText(mIntent.getStringExtra("p2"));
            mC3.setText(mIntent.getStringExtra("p3"));
            mC4.setText(mIntent.getStringExtra("p4"));
            mC5.setText(mIntent.getStringExtra("p5"));
            mC6.setText(mIntent.getStringExtra("p6"));
            mC7.setText(mIntent.getStringExtra("p7"));
            mC8.setText(mIntent.getStringExtra("p8"));
            mC9.setText(mIntent.getStringExtra("p9"));
            factura = coverJson(mIntent);
        }



        mSend.setOnClickListener(v->{
            Intent mIntent2 = new Intent();
            mIntent2.setType("text/plain");
            mIntent2.setAction(Intent.ACTION_SEND);//voy a mandar algo... de tipo texto plan î
            mIntent2.putExtra(Intent.EXTRA_TEXT,factura);
            startActivity(mIntent2);
        });

    }

    private String coverJson(Intent i){
        contador =0;
        contador += Integer.parseInt(i.getStringExtra("p1"));
        contador += Integer.parseInt(i.getStringExtra("p2"));
        contador += Integer.parseInt(i.getStringExtra("p3"));
        contador += Integer.parseInt(i.getStringExtra("p4"));
        contador += Integer.parseInt(i.getStringExtra("p5"));
        contador += Integer.parseInt(i.getStringExtra("p6"));
        contador += Integer.parseInt(i.getStringExtra("p7"));
        contador += Integer.parseInt(i.getStringExtra("p8"));
        contador += Integer.parseInt(i.getStringExtra("p9"));
        String J = "{ \n";
        J+= "Usuario : "+ i.getStringExtra("user") +"\n";
        J+= "email : "+ i.getStringExtra("email") + "\n";
        J+= "producto1 : " + i.getStringExtra("p1") + "\n";
        J+= "producto2 : " + i.getStringExtra("p2") + "\n";
        J+= "producto3 : " + i.getStringExtra("p3") + "\n";
        J+= "producto4 : " + i.getStringExtra("p4") + "\n";
        J+= "producto5 : " + i.getStringExtra("p5") + "\n";
        J+= "producto6 : " + i.getStringExtra("p6") + "\n";
        J+= "producto7 : " + i.getStringExtra("p7") + "\n";
        J+= "producto8 : " + i.getStringExtra("p8") + "\n";
        J+= "producto9 : " + i.getStringExtra("p9") + "\n";
        J+= "total productos : " + contador + "\n";

;       mTotal.setText(String.valueOf(contador));
        return J+= "}";
    }

    private void onLoadContent(){
        mC1 =findViewById(R.id.tv_count_1);
        mC2 =findViewById(R.id.tv_count_2);
        mC3 =findViewById(R.id.tv_count_3);
        mC4 =findViewById(R.id.tv_count_4);
        mC5 =findViewById(R.id.tv_count_5);
        mC6 =findViewById(R.id.tv_count_6);
        mC7 =findViewById(R.id.tv_count_7);
        mC8 =findViewById(R.id.tv_count_8);
        mC9 =findViewById(R.id.tv_count_9);

        mCorreo = findViewById(R.id.tv_email);
        mUser = findViewById(R.id.tv_user);
        mSend = findViewById(R.id.bt_send);
        mTotal = findViewById(R.id.tv_producto);
    }
}
