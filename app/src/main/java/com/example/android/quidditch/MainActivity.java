package com.example.android.quidditch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {


    int scoreS = 0;
    int scoreG = 0;

    Button hoopG;
    Button penaltyG;
    Button snitchG;
    Button hoopS;
    Button penaltyS;
    Button snitchS;

    TextView scoreViewWin;
    TextView scoreViewG;
    TextView scoreViewS;

    String whoWon = "Who will win?";


    /**
     * Griffindor
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoopG = (Button) findViewById(R.id.hoopG);
        penaltyG = (Button) findViewById(R.id.penaltyG);
        snitchG = (Button) findViewById(R.id.snitchG);
        hoopS = (Button) findViewById(R.id.hoopS);
        penaltyS = (Button) findViewById(R.id.penaltyS);
        snitchS = (Button) findViewById(R.id.snitchS);

        scoreViewWin = (TextView) findViewById(R.id.whoWonT);
        scoreViewG = (TextView) findViewById(R.id.G_score);
        scoreViewS = (TextView) findViewById(R.id.S_score);
    }


    public void add10ForG(View view) {
        scoreG = scoreG + 10;
        displayForG();

    }

    public void add20ForG(View view) {
        scoreG = scoreG + 20;
        displayForG();
    }

    public void add150ForG(View view) {
        scoreG = scoreG + 150;
        displayForG();
        winnerCheck();
        enableButtons(false);

    }

    /**
     * Displays the given score for G.
     */
    public void displayForG() {
        scoreViewG.setText(String.valueOf(scoreG));
    }


    /**
     * Slytherin
     */

    public void add10ForS(View view) {
        scoreS = scoreS + 10;
        displayForS();

    }

    public void add20ForS(View view) {
        scoreS = scoreS + 20;
        displayForS();
    }

    public void add150ForS(View view) {
        scoreS = scoreS + 150;
        displayForS();
        winnerCheck();
        enableButtons(false);
    }

    /**
     * Displays the given score for S.
     */
    public void displayForS() {
        scoreViewS.setText(String.valueOf(scoreS));
    }

    public void resetScore(View view) {
        scoreS = 0;
        displayForS();
        scoreG = 0;
        displayForG();
        whoWon = "Who will win?";
        displayWinner(whoWon);
        enableButtons(true);
    }

    /**
     * saving message "whoWon" as a string
     */
    public void displayWinner(String message) {
        whoWon = message;
        scoreViewWin.setText(message);
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


    public void enableButtons(boolean enable) {
        hoopG.setEnabled(enable);
        penaltyG.setEnabled(enable);
        snitchG.setEnabled(enable);
        hoopS.setEnabled(enable);
        penaltyS.setEnabled(enable);
        snitchS.setEnabled(enable);
    }

    /**
     * Method to keep data with rotation
     */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("scoreG", scoreG);
        outState.putInt("scoreS", scoreS);
        outState.putString("whoWon", whoWon);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreG = savedInstanceState.getInt("scoreG", scoreG);
        scoreS = savedInstanceState.getInt("scoreS", scoreS);
        whoWon = savedInstanceState.getString("whoWon", whoWon);
        displayForG();
        displayForS();
        displayWinner(whoWon);

        if (whoWon == "Who will win?") {
            enableButtons(true);
        } else {
            enableButtons(false);
        }
    }


}
