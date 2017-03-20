/* Created by Chase Watson */
package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Stats extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USER_STATS_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + StatsData.UserStatsInfo.TABLE_NAME + "(" + StatsData.UserStatsInfo.SHOTS_AGAINST + " TEXT, " +
            StatsData.UserStatsInfo.SAVES + " TEXT, " + StatsData.UserStatsInfo.GOALS_AGAINST + " TEXT, " + StatsData.UserStatsInfo.GOALS_AGAINST_AVG +
            " TEXT, " + StatsData.UserStatsInfo.SAVE_PERCENTAGE + " TEXT);";

    public Stats (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "STATS Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "STATS Table created");
    }

    public void addStatsInformtion (String saves, String shots_against, String goals_against, String save_percentage, String goals_against_avg, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StatsData.UserStatsInfo.SAVES, saves);
        contentValues.put(StatsData.UserStatsInfo.SHOTS_AGAINST, shots_against);
        contentValues.put(StatsData.UserStatsInfo.GOALS_AGAINST, goals_against);
        contentValues.put(StatsData.UserStatsInfo.SAVE_PERCENTAGE, save_percentage);
        contentValues.put(StatsData.UserStatsInfo.GOALS_AGAINST_AVG, goals_against_avg);
        db.insert(StatsData.UserStatsInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row of the stats table is inserted");
    }

    public Cursor getStatsInformation(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {StatsData.UserStatsInfo.SAVES, StatsData.UserStatsInfo.SHOTS_AGAINST, StatsData.UserStatsInfo.GOALS_AGAINST, StatsData.UserStatsInfo.SAVE_PERCENTAGE, StatsData.UserStatsInfo.GOALS_AGAINST_AVG};
        cursor = db.query(StatsData.UserStatsInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

