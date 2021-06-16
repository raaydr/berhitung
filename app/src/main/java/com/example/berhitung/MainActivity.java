package com.example.berhitung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Home implements OnClickListener{

    private Button tambahBtn,kurangBtn,pembagianBtn,perkalianBtn;

    private String[] levelNames ={"Mudah","Normal","Sulit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        tambahBtn= (Button)findViewById(R.id.play_jum);
        kurangBtn=(Button)findViewById(R.id.play_kur);
        pembagianBtn=(Button)findViewById(R.id.play_bag);
        perkalianBtn=(Button)findViewById(R.id.play_kal);


        tambahBtn.setOnClickListener(this);
        kurangBtn.setOnClickListener(this);
        pembagianBtn.setOnClickListener(this);
        perkalianBtn.setOnClickListener(this);



    }

    public void onClick (View view){

        if (view.getId()== R.id.play_jum){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose a level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPenjumlahan(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();

        } if(view.getId()== R.id.play_kur){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPengurangan(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();

        } if(view.getId()== R.id.play_bag) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPembagian(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        } if(view.getId()== R.id.play_kal){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih Level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPerkalian(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }if(view.getId()== R.id.play_kal){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPerkalian(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }


    }


    private void startPenjumlahan(int chosenLevel){

        Intent playIntent = new Intent(this, Penjumlahan.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);

    }

    private void startPengurangan(int chosenLevel){

        Intent playPengurangan = new Intent(this, Pengurangan.class);
        playPengurangan.putExtra("level", chosenLevel);
        this.startActivity(playPengurangan);

    }

    private void startPembagian(int chosenLevel){

        Intent playIntent = new Intent(this, Pembagian.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);

    }
    private void startPerkalian(int chosenLevel){

        Intent playIntent = new Intent(this, Perkalian.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);

    }


}
