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


public class Penjumlahan extends MainActivity implements OnClickListener{
    public static final String Score_Akhir = "com.example.berhitung.Score_Akhir";
    private int level =0, answer = 0, operand1=0, operand2=0;
    int count = 0;
    int exScore=0;
    private int [] levelMin = {1,11,21};
    private int [] levelMax = {10,25,50};
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
                    //int scoreAkhir = Integer.parseInt(scoreTxt.getText().toString());
                    Intent selesai = new Intent(Penjumlahan.this, HasilKuis.class);
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

        operand1 = getOperand();
        operand2 = getOperand();

        answer = operand1 + operand2;
        question.setText(operand1+ "+"+operand2+"=");
    }

    private int getOperand(){
        return random.nextInt(levelMax[level]- levelMin[level]+1)+ levelMin[level];
    }
}

