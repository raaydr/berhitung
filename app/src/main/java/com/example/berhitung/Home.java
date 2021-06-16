package com.example.berhitung;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button latihanBtn,uasBtn,aboutBtn;

    private String[] levelNames ={"Mudah","Normal","Sulit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        latihanBtn= (Button)findViewById(R.id.play_latihan);
        aboutBtn=(Button)findViewById(R.id.play_about);
        uasBtn=(Button)findViewById((R.id.play_uas));

        latihanBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        uasBtn.setOnClickListener(this);


    }

    public void onClick (View view){

        if (view.getId()== R.id.play_latihan){

            Intent playLatihan = new Intent(this, MainActivity.class);
            this.startActivity(playLatihan);

        }

        if(view.getId()== R.id.play_uas){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startUjian(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }

        if(view.getId()== R.id.play_about){


        }


    }



    private void startUjian(int chosenLevel){

        Intent playIntent = new Intent(this, UjianBerhitung.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);

    }
}
