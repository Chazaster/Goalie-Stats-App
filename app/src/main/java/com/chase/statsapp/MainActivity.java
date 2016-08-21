package com.chase.statsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public void saveStats(View view) {

    }

    int savesNum = 1;
    int goalsNum = 0;
    int shotsNum = 1;
    Button savesMinusClickHere;
    Button savesPlusClickHere;
    Button goalsMinusClickHere;
    Button goalsPlusClickHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /* MINUS BUTTON FOR SAVES */
        savesMinusClickHere = (Button) findViewById(R.id.saveMinusButton);
        savesMinusClickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                TextView savesTextField = (TextView) findViewById(R.id.savesTextField);
                TextView totalShotsTextField = (TextView) findViewById(R.id.totalShotsTextField);
                TextView savePercentageTextField = (TextView) findViewById(R.id.savePercentageTextField);
                savesNum -= 1;
                shotsNum -= 1;
                // Since setText() cannot only pass through an integer,
                // it must include an empty string in order to change num in TextView
                savesTextField.setText("" + savesNum);
                totalShotsTextField.setText("" + shotsNum);

                // Math for save percentage that updates each time plus/minus buttons are pressed
                Double savesAmount = Double.parseDouble(savesTextField.getText().toString());
                Double shotsAmount = Double.parseDouble(totalShotsTextField.getText().toString());
                Double savePercentageAmount = savesAmount / shotsAmount;

                savePercentageTextField.setText("" + savePercentageAmount);
            }
        });

        /* PLUS BUTTON FOR SAVES */
        savesPlusClickHere = (Button) findViewById(R.id.saveButton);
        savesPlusClickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View d) {
                TextView savesTextField = (TextView) findViewById(R.id.savesTextField);
                TextView totalShotsTextField = (TextView) findViewById(R.id.totalShotsTextField);
                TextView savePercentageTextField = (TextView) findViewById(R.id.savePercentageTextField);
                savesNum += 1;
                shotsNum += 1;
                // Since setText() cannot only pass through an integer,
                // it must include an empty string in order to change num in TextView
                savesTextField.setText("" + savesNum);
                totalShotsTextField.setText("" + shotsNum);

                // Math for save percentage that updates each time plus/minus buttons are pressed
                Double savesAmount = Double.parseDouble(savesTextField.getText().toString());
                Double shotsAmount = Double.parseDouble(totalShotsTextField.getText().toString());
                Double savePercentageAmount = savesAmount / shotsAmount;

                savePercentageTextField.setText("" + savePercentageAmount);
            }
        });

        /* MINUS BUTTON FOR GOALS */
        goalsMinusClickHere = (Button) findViewById(R.id.goalMinusButton);
        goalsMinusClickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View e) {
                TextView goalsTextField = (TextView) findViewById(R.id.goalsTextField);
                TextView totalShotsTextField = (TextView) findViewById(R.id.totalShotsTextField);
                TextView savesTextField = (TextView) findViewById(R.id.savesTextField);
                TextView savePercentageTextField = (TextView) findViewById(R.id.savePercentageTextField);
                TextView goalsAgainstAverageTextField = (TextView) findViewById(R.id.goalsAgainstAverageTextField);
                goalsNum -= 1;
                shotsNum -= 1;
                // Since setText() cannot only pass through an integer,
                // it must include an empty string in order to change num in TextView
                goalsTextField.setText("" + goalsNum);
                totalShotsTextField.setText("" + shotsNum);

                // Math for save percentage that updates each time plus/minus buttons are pressed
                Double savesAmount = Double.parseDouble(savesTextField.getText().toString());
                Double shotsAmount = Double.parseDouble(totalShotsTextField.getText().toString());
                Double savePercentageAmount = savesAmount / shotsAmount;

                // Math for goals against average that updates each time plus/minus buttons are pressed
                Double goalsAmount = Double.parseDouble(goalsTextField.getText().toString());
                Double gaaAmount = goalsAmount + .00;

                savePercentageTextField.setText("" + savePercentageAmount);
                goalsAgainstAverageTextField.setText("" + gaaAmount);
            }
        });

        /* PLUS BUTTON FOR GOALS */
        goalsPlusClickHere = (Button) findViewById(R.id.goalButton);
        goalsPlusClickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View f) {
                TextView goalsTextField = (TextView) findViewById(R.id.goalsTextField);
                TextView totalShotsTextField = (TextView) findViewById(R.id.totalShotsTextField);
                TextView savesTextField = (TextView) findViewById(R.id.savesTextField);
                TextView savePercentageTextField = (TextView) findViewById(R.id.savePercentageTextField);
                TextView goalsAgainstAverageTextField = (TextView) findViewById(R.id.goalsAgainstAverageTextField);
                goalsNum += 1;
                shotsNum += 1;
                // Since setText() cannot only pass through an integer,
                // it must include an empty string in order to change num in TextView
                goalsTextField.setText("" + goalsNum);
                totalShotsTextField.setText("" + shotsNum);

                // Math for save percentage that updates each time plus/minus buttons are pressed
                Double savesAmount = Double.parseDouble(savesTextField.getText().toString());
                Double shotsAmount = Double.parseDouble(totalShotsTextField.getText().toString());
                Double savePercentageAmount = savesAmount / shotsAmount;

                // Math for goals against average that updates each time plus/minus buttons are pressed
                Double goalsAmount = Double.parseDouble(goalsTextField.getText().toString());
                Double gaaAmount = goalsAmount + .00;

                savePercentageTextField.setText("" + savePercentageAmount);
                goalsAgainstAverageTextField.setText("" + gaaAmount);
            }
        });
    }
}
