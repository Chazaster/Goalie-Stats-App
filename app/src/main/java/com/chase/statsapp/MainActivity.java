/* Created by Chase Watson */

package com.chase.statsapp;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends FragmentActivity {
    Intent intent;
    int savesNum = 1;
    int goalsNum = 0;
    int shotsNum = 1;
    Double savePercentageAmount;
    Double gaaAmount;
    Button savesMinusClickHere;
    Button savesPlusClickHere;
    Button goalsMinusClickHere;
    Button goalsPlusClickHere;
    Button saveStatsButtonClickHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* SAVE STATS BUTTON */
        saveStatsButtonClickHere = (Button) findViewById(R.id.saveStatsButton);
        saveStatsButtonClickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick (View g) {
                String button_text;
                button_text = ((Button) g).getText().toString();
                if (button_text.equals("Save Stats")) {
                    // Keep track of stats on this activity and save them to specified user on next activity
                    intent = (new Intent(MainActivity.this, UsersActivity.class));
                    intent.putExtra("saves", savesNum);
                    intent.putExtra("shots", shotsNum);
                    intent.putExtra("goals", goalsNum);
                    intent.putExtra("save percentage", savePercentageAmount);
                    intent.putExtra("goals against average", gaaAmount);
                    startActivity(intent);
                }
            }
        });

         /* MINUS BUTTON FOR SAVES */
        savesMinusClickHere = (Button) findViewById(R.id.saveMinusButton);
        savesMinusClickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                TextView savesTextField = (TextView) findViewById(R.id.savesTextField);
                TextView totalShotsTextField = (TextView) findViewById(R.id.totalShotsTextField);
                TextView savePercentageTextField = (TextView) findViewById(R.id.savePercentageTextField);
                savesNum -= 1;
                if (savesNum == 0) shotsNum = goalsNum;
                else if (savesNum <= 0) savesNum = 0;
                else if (shotsNum <= 0) shotsNum = 0;
                else shotsNum -= 1;
                // Since setText() cannot only pass through an integer,
                // it must include an empty string in order to change num in TextView
                savesTextField.setText("" + savesNum);
                totalShotsTextField.setText("" + shotsNum);

                // Math for save percentage that updates each time plus/minus buttons are pressed
                Double savesAmount = Double.parseDouble(savesTextField.getText().toString());
                Double shotsAmount = Double.parseDouble(totalShotsTextField.getText().toString());
                savePercentageAmount = savesAmount / shotsAmount;
                round(savePercentageAmount, 2);

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
                savePercentageAmount = savesAmount / shotsAmount;
                round(savePercentageAmount, 2);

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
                if (goalsNum == 0) shotsNum = savesNum;
                else if (goalsNum <= 0) goalsNum = 0;
                else if (shotsNum <= 0) shotsNum = 0;
                else shotsNum -= 1;
                // Since setText() cannot only pass through an integer,
                // it must include an empty string in order to change num in TextView
                goalsTextField.setText("" + goalsNum);
                totalShotsTextField.setText("" + shotsNum);

                // Math for save percentage that updates each time plus/minus buttons are pressed
                Double savesAmount = Double.parseDouble(savesTextField.getText().toString());
                Double shotsAmount = Double.parseDouble(totalShotsTextField.getText().toString());
                savePercentageAmount = savesAmount / shotsAmount;
                round(savePercentageAmount, 2);

                // Math for goals against average that updates each time plus/minus buttons are pressed
                Double goalsAmount = Double.parseDouble(goalsTextField.getText().toString());
                gaaAmount = goalsAmount + .00;
                round(gaaAmount, 2);

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
                savePercentageAmount = savesAmount / shotsAmount;
                round(savePercentageAmount, 2);

                // Math for goals against average that updates each time plus/minus buttons are pressed
                Double goalsAmount = Double.parseDouble(goalsTextField.getText().toString());
                gaaAmount = goalsAmount + .00;
                round(gaaAmount, 2);

                savePercentageTextField.setText("" + savePercentageAmount);
                goalsAgainstAverageTextField.setText("" + gaaAmount);
            }
        });
    }

    public static double round (double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
