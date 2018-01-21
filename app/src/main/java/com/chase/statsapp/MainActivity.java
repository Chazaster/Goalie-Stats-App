package com.chase.statsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toStats (View view){
        Intent intent = new Intent(MainActivity.this, StatsActivity.class);
        startActivity(intent);
    }

    public void toUsersList(View view) {
        Intent intent = new Intent(MainActivity.this, UsersActivity.class);
        startActivity(intent);
    }

    public void toAddUser(View view) {
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        startActivity(intent);
    }
}

