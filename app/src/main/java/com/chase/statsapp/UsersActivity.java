/* Created by Chase Watson */
package com.chase.statsapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.content.Intent;
import android.widget.ListView;

import Database.UserListData;
import Database.UserDataProvider;
import Database.Users;

public class UsersActivity extends FragmentActivity {
    FloatingActionButton fab;
    Intent intent;
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    Users users;
    Cursor cursor;
    UserListData userListData;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        listView = (ListView) findViewById(R.id.list_view);

        userListData = new UserListData(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(userListData);

        users = new Users(getApplicationContext());
        sqLiteDatabase = users.getReadableDatabase();
        cursor = users.getInformation(sqLiteDatabase);

        if (cursor.moveToFirst()) {
            do {
                // Now display data in listview
                String name, number, team;
                name = cursor.getString(0);
                number = cursor.getString(1);
                team = cursor.getString(2);
                // Passes each row of data into the userListData adapter class
                UserDataProvider dataProvider = new UserDataProvider(name, number, team);
                userListData.add(dataProvider);
            } while (cursor.moveToNext());
        }

        // Add code for saving stats data while clicking user in userListData

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_menu_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = (new Intent(UsersActivity.this, AddUserActivity.class));
                startActivity(intent);
            }
        });
    }
}
