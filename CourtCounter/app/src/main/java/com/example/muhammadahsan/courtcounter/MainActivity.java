package com.example.muhammadahsan.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.muhammadahsan.courtcounter.R.string.resetCounter;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void resetAll(View view){
        scoreTeamA=0;
        scoreTeamB=0;

        teamA(0);
        teamB(0);

        Toast.makeText(this,resetCounter,LENGTH_SHORT).show();
    }
    public void teamA(int score){
        TextView scoreTA = (TextView) findViewById(R.id.textView_teamScoreA);
        scoreTeamA = scoreTeamA + score;
        scoreTA.setText(String.valueOf(scoreTeamA));
    }
    public void addThreeForTeamA(View view){
        teamA(3);
    }
    public void addTwoForTeamA(View view){
        teamA(2);
    }
    public void addOneForTeamA(View view){
        teamA(1);
    }

    public void teamB(int score){
        TextView scoreTB = (TextView) findViewById(R.id.textView_teamScoreB);
        scoreTeamB = scoreTeamB + score;
        scoreTB.setText(String.valueOf(scoreTeamB));
    }
    public void addThreeForTeamB(View view){
        teamB(3);
    }
    public void addTwoForTeamB(View view){
        teamB(2);
    }
    public void addOneForTeamB(View view){
        teamB(1);
    }
}
