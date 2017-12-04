package com.example.android.quidditch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {


    /**
     * Griffindor
     */

    int scoreG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add10ForG(View view) {
        scoreG = scoreG + 10;
        displayForG(scoreG);

    }

    public void add20ForG(View view) {
        scoreG = scoreG + 20;
        displayForG(scoreG);
    }

    public void add150ForG(View view) {
        scoreG = scoreG + 150;
        displayForG(scoreG);
        winnerCheck();
        disableButtons();

    }

    /**
     * Displays the given score for G.
     */
    public void displayForG(int score) {
        TextView scoreView = (TextView) findViewById(R.id.G_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Slytherin
     */

    int scoreS = 0;

    public void add10ForS(View view) {
        scoreS = scoreS + 10;
        displayForS(scoreS);

    }

    public void add20ForS(View view) {
        scoreS = scoreS + 20;
        displayForS(scoreS);
    }

    public void add150ForS(View view) {
        scoreS = scoreS + 150;
        displayForS(scoreS);
        winnerCheck();
        disableButtons();
    }

    /**
     * Displays the given score for S.
     */
    public void displayForS(int score) {
        TextView scoreView = (TextView) findViewById(R.id.S_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetScore(View view) {
        scoreS = 0;
        displayForS(scoreS);
        scoreG = 0;
        displayForG(scoreG);
        whoWon = "Who will win?";
        displayWinner(whoWon);
        enableButtons();

    }

    /** saving message "whoWon" as a string
     */
    String whoWon = "Who will win?";


    public void displayWinner(String message) {
        whoWon = message;
        TextView scoreView = (TextView) findViewById(R.id.whoWonT);
        scoreView.setText(message);
    }


    public void winnerCheck() {
        if (scoreG > scoreS) {
            displayWinner("Gryffindor WINS!");
        } else if (scoreG < scoreS) {
            displayWinner("Slytherin WINS!");
        } else if (scoreG == scoreS) {
            displayWinner("Tie!");
        }

    }

    public void enableButtons() {
        Button hoopG = (Button) findViewById(R.id.hoopG);
        hoopG.setEnabled(true);
        Button penaltyG = (Button) findViewById(R.id.penaltyG);
        penaltyG.setEnabled(true);
        Button snitchG = (Button) findViewById(R.id.snitchG);
        snitchG.setEnabled(true);
        Button hoopS = (Button) findViewById(R.id.hoopS);
        hoopS.setEnabled(true);
        Button penatlyS = (Button) findViewById(R.id.penaltyS);
        penatlyS.setEnabled(true);
        Button snitchS = (Button) findViewById(R.id.snitchS);
        snitchS.setEnabled(true);
    }

    public void disableButtons() {
        Button hoopG = (Button) findViewById(R.id.hoopG);
        hoopG.setEnabled(false);
        Button penaltyG = (Button) findViewById(R.id.penaltyG);
        penaltyG.setEnabled(false);
        Button snitchG = (Button) findViewById(R.id.snitchG);
        snitchG.setEnabled(false);
        Button hoopS = (Button) findViewById(R.id.hoopS);
        hoopS.setEnabled(false);
        Button penatlyS = (Button) findViewById(R.id.penaltyS);
        penatlyS.setEnabled(false);
        Button snitchS = (Button) findViewById(R.id.snitchS);
        snitchS.setEnabled(false);

    }

    /**
     Method to keep data with rotation
     */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("scoreG",scoreG);
        outState.putInt("scoreS",scoreS);
        outState.putString("whoWon",whoWon);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreG=savedInstanceState.getInt("scoreG",scoreG);
        scoreS=savedInstanceState.getInt("scoreS",scoreS);
        whoWon=savedInstanceState.getString("whoWon",whoWon);
        displayForG(scoreG);
        displayForS(scoreS);
        displayWinner(whoWon);

        if (whoWon=="Who will win?"){
          enableButtons();
        } else {
            disableButtons();
        }
    }



}
