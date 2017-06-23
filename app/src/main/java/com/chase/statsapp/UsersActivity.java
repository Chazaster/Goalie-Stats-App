/* Created by Chase Watson */

package com.chase.statsapp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import Database.UserListData;
import Database.UserDataProvider;
import Database.Users;
import android.widget.TextView;
import android.content.ClipData.Item;
import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends FragmentActivity {
    FloatingActionButton fab;
    Intent intent;
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    Users users;
    Cursor cursor;
    UserListData userListData;
    TextView row_layout_name, row_layout_number, row_layout_team;
    String data_name, data_team, data_number;
    List<Item> nameData = new ArrayList<>();
    List<Item> numberData = new ArrayList<>();
    List<Item> teamData = new ArrayList<>();

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
        // Cursor contains all info within user table in database
        if (cursor.moveToFirst()) {
            do {
                // Now display data in listview
                String name, number, team;
                name = cursor.getString(0);
                number = cursor.getString(1);
                team = cursor.getString(2);
                // Pass names, numbers, and teams to data lists
                nameData.add(new Item(name));
                numberData.add(new Item(number));
                teamData.add(new Item(team));

                // Passes each row of data into the userListData adapter class
                UserDataProvider dataProvider = new UserDataProvider(name, number, team);
                userListData.add(dataProvider);
            } while (cursor.moveToNext());
        }

        // Listening to single ListView item on click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Gather data of selected user
                row_layout_name = (TextView) findViewById(R.id.text_user_name);
                row_layout_number = (TextView) findViewById(R.id.text_user_number);
                row_layout_team = (TextView) findViewById(R.id.text_user_team);

                data_name = row_layout_name.getText().toString();
                data_number = row_layout_number.getText().toString();
                data_team = row_layout_team.getText().toString();

                String nameItem = String.valueOf(nameData.get(position));
                String numberItem = String.valueOf(numberData.get(position));
                String teamItem = String.valueOf(teamData.get(position));
                // Now launch new activity on selected item
                Intent i = new Intent(getApplicationContext(), UserStatsActivity.class);
                // Send data to new activity
                i.putExtra("name", nameItem);
                i.putExtra("number", numberItem);
                i.putExtra("team", teamItem);
                i.putExtras(getIntent().getExtras());
                startActivity(i);
            }
        });

        // Floating Action Button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_menu_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(UsersActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
