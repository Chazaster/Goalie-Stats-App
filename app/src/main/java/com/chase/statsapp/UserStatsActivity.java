// Created by Chase Watson

package com.chase.statsapp;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import Database.Stats;
import Database.Users;

public class UserStatsActivity extends FragmentActivity {
    Users users;
    Stats stats;
    SQLiteDatabase sqLiteDatabase;
    String name, number, team;
    String originalName, middleName, newName;
    String originalNumber, middleNumber, newNumber;
    String originalTeam, middleTeam, newTeam;
    TextView user_shots_against, user_saves, user_goals_against, user_save_percentage, user_goals_against_average;
    TextView added_shots, added_saves, added_goals_against, added_svp, added_gaa;
    Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userstats);
        TextView user_name = (TextView) findViewById(R.id.user_name);
        TextView user_number = (TextView) findViewById(R.id.user_number);
        TextView user_team = (TextView) findViewById(R.id.user_team);
        user_shots_against = (TextView) findViewById(R.id.user_total_shots_against);
        user_saves = (TextView) findViewById(R.id.user_total_saves);
        user_goals_against = (TextView) findViewById(R.id.user_total_goals_against);
        user_save_percentage = (TextView) findViewById(R.id.user_save_percentage);
        user_goals_against_average = (TextView) findViewById(R.id.user_goals_against_average);
        added_shots = (TextView) findViewById(R.id.adding_shots_against);
        added_saves = (TextView) findViewById(R.id.adding_saves);
        added_goals_against = (TextView) findViewById(R.id.adding_goals_against);
        added_svp = (TextView) findViewById(R.id.adding_save_percentage);
        added_gaa = (TextView) findViewById(R.id.adding_goals_against_average);

        user_name.setText(String.valueOf(getIntent().getStringExtra("name")));
        user_number.setText(String.valueOf(getIntent().getStringExtra("number")));
        user_team.setText(String.valueOf(getIntent().getStringExtra("team")));
        // Start manipulating data to get total stats
        added_shots.setText(String.valueOf("+" + getIntent().getIntExtra("shots", 0)));
        added_saves.setText(String.valueOf("+" + getIntent().getIntExtra("saves", 0)));
        added_goals_against.setText(String.valueOf("+" + getIntent().getIntExtra("goals", 0)));
        added_svp.setText(String.valueOf("+" + getIntent().getDoubleExtra("save percentage", 0)));
        added_gaa.setText(String.valueOf("+" + getIntent().getDoubleExtra("goals against average", 0)));

        stats = new Stats(getApplicationContext());
        sqLiteDatabase = stats.getReadableDatabase();
        cursor = stats.getStatsInformation(sqLiteDatabase);

        // Add line to add data to database
        // This might be used for intially inserting data into empty database
        // If database is already populated, take code from saveUser class and...
        // ...move it up here; saveUser should not do any manipulation of data...
        // ...it should instead just save already-manipulated data

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

    public void saveUser(View view) {
        users = new Users(getApplicationContext());
        sqLiteDatabase = users.getReadableDatabase();
        ContentValues cv = new ContentValues();
        /*cv.put(StatsData.UserStatsInfo.SAVES, );
        cv.put(StatsData.UserStatsInfo.GOALS_AGAINST, );
        cv.put(StatsData.UserStatsInfo.SHOTS_AGAINST, );
        cv.put(StatsData.UserStatsInfo.SAVE_PERCENTAGE, );
        cv.put(StatsData.UserStatsInfo.GOALS_AGAINST_AVG, );
        users.saveUser(newName, sqLiteDatabase, cv);*/
        Toast.makeText(getBaseContext(), "User " + newName + " Saved", Toast.LENGTH_LONG).show();
        Intent i = new Intent(UserStatsActivity.this, UsersActivity.class);
        startActivity(i);
    }
}
