package com.example.berhitung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HasilKuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        Intent intent = getIntent();
        int scoreAkhir = intent.getIntExtra("NILAI",0);
        nilai.setText(String.valueOf(scoreAkhir));

    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(a);
    }

    public void menuhome(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),Home.class);
        startActivity(a);
    }
}
