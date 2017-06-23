/* Created by Chase Watson */

package Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Users extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USER_INFO_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + UsersData.NewUserInfo.TABLE_NAME + "(" + UsersData.NewUserInfo.USER_ID + " INT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                    UsersData.NewUserInfo.USER_NAME + " TEXT, " + UsersData.NewUserInfo.NUMBER + " TEXT, " + UsersData.NewUserInfo.TEAM_NAME + " TEXT);";
    private static final String UNFINISHED_DELETE_QUERY = "DELETE FROM " + UsersData.NewUserInfo.TABLE_NAME + "WHERE " +
            UsersData.NewUserInfo.USER_NAME + "= ";
    private static String DELETE_QUERY;

    public Users (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "USERS Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "USERS Table created");
    }

    public void addInformation(String name, String number, String team, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersData.NewUserInfo.USER_NAME, name);
        contentValues.put(UsersData.NewUserInfo.NUMBER, number);
        contentValues.put(UsersData.NewUserInfo.TEAM_NAME, team);
        db.insert(UsersData.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row of the users table is inserted");
    }

    public Cursor getInformation(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {UsersData.NewUserInfo.USER_NAME, UsersData.NewUserInfo.NUMBER, UsersData.NewUserInfo.TEAM_NAME};
        cursor = db.query(UsersData.NewUserInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    }

    public void deleteUser (String user_name, SQLiteDatabase db) {
        String selection = UsersData.NewUserInfo.USER_NAME + " LIKE ?";
        String[] selection_args = {user_name};
        db.delete(UsersData.NewUserInfo.TABLE_NAME, selection, selection_args);

        /*
        DELETE_QUERY = UNFINISHED_DELETE_QUERY + var;
        Log.e(DELETE_QUERY, "is what will be executed");
        Log.e(var, "is the user that will be deleted");
        db.execSQL(DELETE_QUERY);
        Log.e("DATABASE OPERATIONS", "USER DELETED");
        db.execSQL("DROP TABLE IF EXISTS user_info");
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
