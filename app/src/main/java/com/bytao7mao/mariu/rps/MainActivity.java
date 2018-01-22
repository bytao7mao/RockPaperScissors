package com.bytao7mao.mariu.rps;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock, paper, scissors;
    ImageView iv_cpu, iv_user;
    String myChoice, cpuChoice, result;
    Random r;
    int scoreUser = 0;
    int scoreCpu = 0;
    Button btnBOT,btn2,btn3;
    String name;
    Button backButton;
    private static final String NAME = "name";
    //setting custom fonts


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer rockSound = MediaPlayer.create(this, R.raw.st);
        final MediaPlayer paperSound = MediaPlayer.create(this, R.raw.papier);
        final MediaPlayer scissorsSound = MediaPlayer.create(this, R.raw.scis);

        TextView txtV = findViewById(R.id.theUserName);

        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            name = lastIntent.getString(NAME);
        }
        txtV.setText(name);
        configureBackButton();




        btnBOT = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnBOT.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);

        displayForUser(scoreUser);
        displayForCpu(scoreCpu);

        iv_cpu = findViewById(R.id.cpuChoice);
        iv_user = findViewById(R.id.userChoice);

        rock = findViewById(R.id.rockBtn);
        paper = findViewById(R.id.paperBtn);
        scissors = findViewById(R.id.scissorsBtn);
        r = new Random();

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "rock";
                rockSound.start();
                iv_user.setImageResource(R.drawable.rock);
                try {
                    calculate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "paper";
                paperSound.start();
                iv_user.setImageResource(R.drawable.paper);
                try {
                    calculate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "scissors";
                scissorsSound.start();
                iv_user.setImageResource(R.drawable.scissors);
                try {
                    calculate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }




    public void reset(View v){
        displayForCpu(scoreCpu = 0);
        displayForUser(scoreUser = 0);
    }
    public void displayForUser(int score){
        TextView scoreViewA = findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(score));
    }
    public void displayForCpu(int score){
        TextView scoreViewB = findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(score));
    }


    public void calculate() throws InterruptedException {
        int cpu = r.nextInt(3);
        if (cpu == 0) {
           // Toast.makeText(MainActivity.this, "The bot is unsure about his move ... but he choose ROCK", Toast.LENGTH_LONG).show();

            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == 1) {
           // Toast.makeText(MainActivity.this, "The bot is unsure about his move ... but he choose PAPER", Toast.LENGTH_LONG).show();
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == 2) {
           // Toast.makeText(MainActivity.this, "The bot is unsure about his move ... but he choose SCISSORS", Toast.LENGTH_LONG).show();
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(myChoice.equals("rock") && cpuChoice.equals("paper")){
          //  Thread.sleep(2000);
            result = "You Lose";
            scoreCpu++;
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("rock") && cpuChoice.equals("scissors")){
           // Thread.sleep(2000);
            result = "You win";
            scoreUser++;
            displayForUser(scoreUser);
        } else if(myChoice.equals("paper") && cpuChoice.equals("rock")){
          //  Thread.sleep(2000);
            result = "You win";
            scoreUser++;
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("paper") && cpuChoice.equals("scissors")){
          //  Thread.sleep(2000);
            result = "You lose";
            scoreCpu++;
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("scissors") && cpuChoice.equals("paper")){
           // Thread.sleep(2000);
            result = "You win";
            scoreUser++;
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("scissors") && cpuChoice.equals("rock")){
           // Thread.sleep(2000);
            result = "You lose";
            scoreCpu++;
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("rock") && cpuChoice.equals("rock")){
           // Thread.sleep(2000);
            result = "draw";
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("scissors") && cpuChoice.equals("scissors")){
           // Thread.sleep(2000);
            result = "draw";
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        } else if(myChoice.equals("paper") && cpuChoice.equals("paper")){
           // Thread.sleep(2000);
            result = "draw";
            displayForUser(scoreUser);
            displayForCpu(scoreCpu);
        }


        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }




    private void configureBackButton(){
        backButton = findViewById(R.id.options);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

}
