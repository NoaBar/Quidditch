package com.example.android.quidditch;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /** Griffindor */

    int scoreG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add10ForG (View view) {
        scoreG = scoreG + 10;
        displayForG (scoreG);

    }

    public void add20ForG (View view) {
        scoreG = scoreG + 20;
        displayForG (scoreG);
    }

    public void add150ForG (View view) {
        scoreG = scoreG + 150;
        displayForG (scoreG);
        winnerCheck();
    }

    /**
     * Displays the given score for G.
     */
    public void displayForG(int score) {
        TextView scoreView = (TextView) findViewById(R.id.G_score);
        scoreView.setText(String.valueOf(score));
    }



/** Slytherin */

    int scoreS = 0;

    public void add10ForS (View view) {
        scoreS = scoreS + 10;
        displayForS (scoreS);

    }

    public void add20ForS (View view) {
        scoreS = scoreS + 20;
        displayForS (scoreS);
    }

    public void add150ForS (View view) {
        scoreS = scoreS + 150;
        displayForS (scoreS);
        winnerCheck ();
    }

    /**
     * Displays the given score for S.
     */
    public void displayForS(int score) {
        TextView scoreView = (TextView) findViewById(R.id.S_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetScore (View view) {
        scoreS = 0;
        displayForS (scoreS);
        scoreG = 0;
        displayForG (scoreG);
    }

    public void winnerCheck() {
        if (scoreG > scoreS) {
            displayForGString("WINS!");
        }
        else if (scoreG < scoreS) {
            displayForSString("WINS!");
        }
        else if (scoreG == scoreS) {
            displayForSString("Tie!");
            displayForGString("Tie!");
        }
    }
    public void displayForSString(String result) {
        TextView scoreView = (TextView) findViewById(R.id.S_score);
        scoreView.setText(result);
    }

    public void displayForGString(String result) {
        TextView scoreView = (TextView) findViewById(R.id.G_score);
        scoreView.setText(result);
    }



    /**
     * להוסיף שהמספרים לא יתאפסו בסיבוב מסך
     */


 }
