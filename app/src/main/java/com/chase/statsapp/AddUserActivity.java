/* Created by Chase Watson */

package com.chase.statsapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import Database.Users;

public class AddUserActivity extends FragmentActivity {
    EditText UserName, UserNumber, UserTeam;
    Context context = this;
    Users users;
    SQLiteDatabase sqLiteDatabase;
    Button addUserButton;
    Button cancelButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        UserName = (EditText) findViewById(R.id.editNameText);
        UserNumber = (EditText) findViewById(R.id.editNumberText);
        UserTeam = (EditText) findViewById(R.id.editTeamText);
    }

    public void addUser (View view) {
        String name = UserName.getText().toString();
        String number = UserNumber.getText().toString();
        String team = UserTeam.getText().toString();
        users = new Users(context);
        sqLiteDatabase = users.getWritableDatabase();
        users.addInformation(name, number, team, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();

        /* SAVE BUTTON */
        addUserButton = (Button) findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View g) {
                finish();
            }
        });
        users.close();
    }

    public void cancel (View view) {
        /* CANCEL BUTTON */
        cancelButton = (Button) findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View g) {
                finish();
            }
        });
    }
}

