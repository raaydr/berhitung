package com.example.berhitung;
import android.app.Activity;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class UjianBerhitung extends MainActivity implements OnClickListener{
    public static final String Score_Akhir = "com.example.berhitung.Score_Akhir";
    private int level =0, operator1,operator2,operator3,operator4, answer = 0, operand1=0, operand2=0,operand3=0,operand4=0,operand5=0;
    int count = 0;
    int exScore=0;
    int masukloop=1;
    final int Penjumlahan=0, Pengurangan=1 ,Perkalian=2,Pembagian =3;
    private int angka [];
    private Random random;
    private TextView question, answerTxt, scoreTxt;
    private Button enterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penjumlahan);

        question= (TextView)findViewById(R.id.question);
        answerTxt=(EditText)findViewById(R.id.answer);
        scoreTxt=(TextView)findViewById(R.id.score);
        enterBtn=(Button)findViewById(R.id.enterBtn);
        random= new Random();

        enterBtn.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            int passedLevel = extras.getInt("level", -1);
            if(passedLevel>=0) level = passedLevel;
        }

        choseQuestion();

    }

    @Override
    public void onClick(View view) {


        boolean masup = true;
        if (view.getId()== R.id.enterBtn ){

            if(answerTxt.length()==0){

                Toast.makeText(getApplication(), "Jawaban tidak boleh kosong", Toast.LENGTH_LONG).show();
            } else {
                String answerInput = answerTxt.getText().toString();
                int answerReady = Integer.parseInt(answerInput);
                // int exScore = getScore();
                if(answerReady == answer){

                    exScore= exScore + 1;
                    scoreTxt.setText("Score: "+(exScore));
                    Toast.makeText(getApplication(), "Jawaban benar", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplication(), "Jawaban salah\nJawaban yang benar "+answer, Toast.LENGTH_LONG).show();
                }

                count = count + 1;

                answerTxt.setText("");

                if(count==10) {
                    finish();
                    count = 0;
                    //int scoreAkhir = Integer.parseInt(scoreTxt.getText().toString());
                    Intent selesai = new Intent(UjianBerhitung.this, HasilKuis.class);
                    selesai.putExtra("NILAI",exScore);
                    //selesai.putExtra(Score_Akhir, exScore);
                    startActivity(selesai);
                }else {
                    choseQuestion();
                }
            }

        }
    }


    private void choseQuestion(){

            if(level==0){
                int pola = 4;
                int soal = random.nextInt(pola - 1 + 1)+1;
                int levelMin = 1;
                int levelMax=10;

                if (soal == 1){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;

                    answer = operand1 + operand2 + operand3;
                    question.setText(operand1+ "+"+operand2+"+"+operand3+"=");


                }else if(soal == 2){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    if ( operand1<operand2) {
                        operand2 = operand1 + operand2;//15
                        operand1 = operand2 - operand1;//10
                        operand2 = operand2 - operand1;//5
                    }
                    answer = operand1 - operand2 + operand3;
                    question.setText(operand1+ "-"+operand2+"+"+operand3+"=");


                }else if (soal==3){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    if ( operand1<operand2) {
                        operand2 = operand1 + operand2;//15
                        operand1 = operand2 - operand1;//10
                        operand2 = operand2 - operand1;//5
                    }
                    answer = operand3 + operand1 - operand2;
                    question.setText(operand3+ "+"+operand1+"-"+operand2+"=");


                }else if(soal==4){
                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    int answer1 = operand1 - operand2 - operand3;
                    if ( answer1 < 0) {
                        operand1 = operand1+operand2+operand3;
                    }
                    answer = operand1 - operand2 - operand3;
                    question.setText(operand1+ "-"+operand2+"-"+operand3+"=");

                }
            }

            if(level==1){
                int pola = 10;
                int soal = random.nextInt(pola - 1 + 1)+1;
                //int soal = 8;

                int levelMin = 2;
                int levelMax=20;

                if (soal == 1){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;

                    answer = operand1 + operand2 * operand3;
                    question.setText(operand1+ " + "+operand2+" x "+operand3+"=");


                }

                if (soal == 2){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    if ( operand1<operand2) {
                        operand2 = operand1 + operand2;//15
                        operand1 = operand2 - operand1;//10
                        operand2 = operand2 - operand1;//5
                    }
                    operand1 = (operand1 * operand3);
                    answer = operand1 - operand2 * operand3;
                    question.setText(operand1+ " - "+operand2+" x "+operand3+"=");


                }

                if (soal == 3){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;

                    answer = operand1 * operand2 + operand3;
                    question.setText(operand1+ " x "+operand2+" + "+operand3+"=");


                }

                if (soal == 4){

                    operand1 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand2 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    operand3 = random.nextInt(levelMax- levelMin+1)+ levelMin;
                    if ( operand1<operand2) {
                        operand2 = operand1 + operand2;//15
                        operand1 = operand2 - operand1;//10
                        operand2 = operand2 - operand1;//5
                    }
                    answer = operand1 + operand2 * operand3;
                    question.setText(operand1+ " + "+operand2+" x "+operand3+"=");



                }

                if (soal == 5){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;

                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double answer1 = operands1 + operands2 / operands3;
                        answer = operand1 + operand2 / operand3;
                        double check = answer1 % 1;
                        if (check == 0&&(operand3!=operand2)) {
                            masuk = false;
                            question.setText(operand1 + " + " + operand2 + " / " + operand3 + "=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if (soal == 6){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        if (operand1 < operand2) {
                            operand2 = operand1 + operand2;//15
                            operand1 = operand2 - operand1;//10
                            operand2 = operand2 - operand1;//5
                        }
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double answer1 = operands2 / operands3;
                        answer = operand1 - operand2 / operand3;
                        double check = answer1 % 1;
                        if (check == 0&&(operand2!=operand3)) {
                            masuk = false;
                            question.setText(operand1 + " - " + operand2 + " / " + operand3 + "=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if (soal == 7){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double answer1 = operands1 / operands2 + operands3;
                        answer = operand1 / operand2 + operand3;
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText(operand1 + " / " + operand2 + " + " + operand3 + "=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if (soal == 8){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;



                        int c = random.nextInt(7 - 1 ) + 2;
                        operand2=operand1;
                        operand1 = c * operand1;
                        operand3 = random.nextInt(c - 1 ) +2;

                       // double divide = operand1 / operand2;
                       // double we = Math.floor(divide);
                       // int stand = (int) we;
                        //operand3 = random.nextInt(stand - 1 ) + 1;

                        double operands1 = operand1;
                        double operands2 = operand2;
                        int operands3 = operand3;
                        double answer1 = operands1 / operands2 ;
                        //answer = operand1 / operand2 - operand3;
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            //operand3 = random.nextInt(stand - 1 ) + 1;
                            answer = operand1 / operand2 - operand3;
                            question.setText(operand1 + " / " + operand2 + " - " + operand3 + "=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if (soal == 9){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;

                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double answer1 = operands1 * operands2 / operands3;
                        answer = operand1 * operand2 / operand3;
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText(operand1 + " x " + operand2 + " / " + operand3 + "=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if (soal == 10){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double answer1 = operands1 / operands2 ;
                        answer = operand1 / operand2 * operand3;
                        double check = answer1 % 1;

                        if (check == 0) {
                            masuk = false;
                            question.setText(operand1 + " / " + operand2 + " x " + operand3 + "=");

                        } else {
                            masuk = true;

                        }


                    }
                }

            }

            if(level==2){

                int pola = 12;

                int soal = random.nextInt(pola - 1 + 1)+1;
                //int soal =3;

                int levelMin = 5;
                int levelMax=20;

                if (soal==1){

                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        if ( operand3<operand4) {
                            operand4 = operand3 + operand4;//15
                            operand3 = operand4 - operand3;//10
                            operand4 = operand4 - operand3;//5
                        }

                         answer = operand1 + operand2 * operand3 - operand4;



                        question.setText(operand1 + " + " + operand2 + " x " + operand3 + " - "+operand4+"=");
                }

                if(soal==2){

                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        if ( operand3<operand4) {
                            operand4 = operand3 + operand4;//15
                            operand3 = operand4 - operand3;//10
                            operand4 = operand4 - operand3;//5
                        }

                        answer = operand1 * operand2 + operand3 - operand4;


                        question.setText(operand1 + " x " + operand2 + " + " + operand3 + " - "+operand4+"=");

                }

                if(soal==13){
                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;

                        double answer1 = operands3 / operands4;
                        int answer2 = operand1 + operand2;
                        double answer3 = answer1 - answer2;
                        answer = operand1 + operand2 - operand3 / operand4;
                        double check = answer1 % 1;
                        if (check == 0 && answer3>0) {
                            masuk = false;
                            question.setText(operand1 + " + " + operand2 + " - " + operand3 + " / "+ operand4+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==4){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        double answer1 = operands1 / operands2;
                        if ( operand3<operand4) {
                            operand4 = operand3 + operand4;//15
                            operand3 = operand4 - operand3;//10
                            operand4 = operand4 - operand3;//5
                        }

                        answer = operand1 / operand2 + operand3 - operand4;
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText(operand1 + " / " + operand2 + " + " + operand3 + " - "+ operand4+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==5){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        double answer1 = operands3 / operands4;


                        answer = operand1 + operand2 * operand3 / operand4;
                        double check = (answer1*operands2) % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText(operand1 + " + " + operand2 + " x " + operand3 + " / "+ operand4+"=");

                        } else {
                            masuk = true;

                        }


                    }


                }

                if(soal==6){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        answer = operand1 * operand2 - operand3 * operand4;

                        if (answer > 0) {
                            masuk = false;
                            question.setText(operand1 + " x " + operand2 + " - " + operand3 + " x "+ operand4+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==7){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        double answer1 = operands3 / operands4;


                        answer = operand1 * operand2 - operand3 / operand4;
                        double check = answer1 % 1;
                        if (check == 0 && answer >0) {
                            masuk = false;
                            question.setText(operand1 + " x " + operand2 + " - " + operand3 + " / "+ operand4+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==8){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        double answer1 = operands3 / operands4;


                        answer = operand1 * operand2 + operand3 / operand4;
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText(operand1 + " x " + operand2 + " + " + operand3 + " / "+ operand4+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==9){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        double answer1 = (operands1 * operands2) / (operands3 * operands4);


                        answer = (operand1 * operand2) / (operand3 * operand4);
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText("("+operand1 + " x " + operand2 +")"+ " / "+"(" + operand3 + " - "+ operand4+")"+"=");

                        } else {
                            masuk = true;

                        }


                    }


                }

                if(soal==11){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;

                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;

                        int c = random.nextInt(8 - 1 ) + 2;
                        operand2=operand1;
                        operand1 = c * operand1;
                        int d = random.nextInt(8 - 1 ) +2;
                        operand4 = operand3;
                        operand3=d * operand3;



                        answer = (operand1 / operand2) * (operand3 / operand4);
                        int check3 = answer %1;
                        if (check3 == 0) {
                            masuk = false;
                            question.setText("("+operand1 + " / " + operand2 +")"+ " x "+"(" + operand3 + " / "+ operand4+")"+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==10){

                    boolean masuk = true;
                    while(masuk==true) {


                        operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;

                        operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;

                        int c = random.nextInt(8 - 1 ) + 2;
                        //int c = 2;

                        operand2=operand1;
                        operand1 = c * operand1;
                        int d = random.nextInt(c -1 ) +2;
                        operand4 = operand3;
                        operand3=d * operand3;

                        double operands1 = operand1;
                        double operands2 = operand2;
                        double operands3 = operand3;
                        double operands4 = operand4;
                        double answer1 = (operands1 / operands2) / (operands3 / operands4);


                        answer = (operand1 / operand2) / (operand3 / operand4);
                        double check = answer1 % 1;
                        if (check == 0) {
                            masuk = false;
                            question.setText("("+operand1 + " / " + operand2 +")"+ " / "+"(" + operand3 + " / "+ operand4+")"+"=");

                        } else {
                            masuk = true;

                        }


                    }
                }

                if(soal==3){

                    operand1 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                    operand2 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                    operand3 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                    operand4 = random.nextInt(levelMax - levelMin + 1) + levelMin;
                    double operands1 = operand1;
                    double operands2 = operand2;
                    double operands3 = operand3;
                    double operands4 = operand4;

                    answer = operand1 * operand2 * operand3 * operand4;
                    question.setText(operand1 + " x " + operand2 + " x "+ operand3 + " x "+ operand4+"=");


                }






            }

    }

    private int[] loopAngka(int c,int min, int max){

        int [] angka = new int[c];
        for (int i=0;i<c;i++){

            angka[i]= random.nextInt(max - min +1)+ min;


        }

    return angka;
    }

    private int[] loopOperator(int c,String[] operator){
        int b = c - 1;
        int [] operasi = new int[b];
        for (int i=0;i<b;i++){

            operasi[i]=  random.nextInt(operator.length);

        }

        return operasi;
    }





}

