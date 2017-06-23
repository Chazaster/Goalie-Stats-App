// Created by Chase Watson

package com.chase.statsapp;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import Database.Users;

public class UserStatsActivity extends FragmentActivity {
    Users users;
    SQLiteDatabase sqLiteDatabase;
    String name, number, team;
    String originalName, middleName, newName;
    String originalNumber, middleNumber, newNumber;
    String originalTeam, middleTeam, newTeam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userstats);
        TextView user_name = (TextView) findViewById(R.id.user_name);
        TextView user_number = (TextView) findViewById(R.id.user_number);
        TextView user_team = (TextView) findViewById(R.id.user_team);
        TextView user_shots_against = (TextView) findViewById(R.id.user_total_shots_against);
        TextView user_saves = (TextView) findViewById(R.id.user_total_saves);
        TextView user_goals_against = (TextView) findViewById(R.id.user_total_goals_against);
        TextView user_save_percentage = (TextView) findViewById(R.id.user_save_percentage);
        TextView user_goals_against_average = (TextView) findViewById(R.id.user_goals_against_average);

        user_name.setText(String.valueOf(getIntent().getStringExtra("name")));
        user_number.setText(String.valueOf(getIntent().getStringExtra("number")));
        user_team.setText(String.valueOf(getIntent().getStringExtra("team")));
        user_shots_against.setText(String.valueOf(getIntent().getIntExtra("shots", 0)));
        user_saves.setText(String.valueOf(getIntent().getIntExtra("saves", 0)));
        user_goals_against.setText(String.valueOf(getIntent().getIntExtra("goals", 0)));
        user_save_percentage.setText(String.valueOf(getIntent().getDoubleExtra("save percentage", 0)));
        user_goals_against_average.setText(String.valueOf(getIntent().getDoubleExtra("goals against average", 0)));

        // To get rid of ClipData.Item bullshit for name
        name = user_name.getText().toString();
        originalName = name;
        middleName = originalName.replace("ClipData.Item { T:","");
        newName = middleName.replace(" }", "");
        user_name.setText(newName);

        // To get rid of ClipData.Item bullshit for number
        number = user_number.getText().toString();
        originalNumber = number;
        middleNumber = originalNumber.replace("ClipData.Item { T:","");
        newNumber = middleNumber.replace(" }", "");
        user_number.setText(newNumber);

        // To get rid of ClipData.Item bullshit for team
        team = user_team.getText().toString();
        originalTeam = team;
        middleTeam = originalTeam.replace("ClipData.Item { T:","");
        newTeam = middleTeam.replace(" }", "");
        user_team.setText(newTeam);
    }

    public void deleteUser (View view) {
        users = new Users(getApplicationContext());
        sqLiteDatabase = users.getReadableDatabase();
        users.deleteUser(newName, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "User " + newName + " Deleted", Toast.LENGTH_LONG).show();
    }
}
