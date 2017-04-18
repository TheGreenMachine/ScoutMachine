package android.greenmachine.otih_oith.com.scoutmachine;

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteOpenHelper;
import android.greenmachine.otih_oith.com.scoutmachine.SQLiteOpenHelper.TeamTableContract;

/**
 * Created by User on 3/18/2017.
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper{

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TeamTableContract.TeamTable.TABLE_NAME + " (" +
                    TeamTableContract.TeamTable._ID + " INTEGER PRIMARY KEY," +
                    TeamTableContract.TeamTable.COLUMN_NAME_TEAM_NUMBER + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_POINTS + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_WALK + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_DEFENCE + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_GEARS + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_BAllS + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_PILOT_RATING + " TEXT," +
                    TeamTableContract.TeamTable.COLUMN_NAME_DRIVER_PERFORM + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TeamTableContract.TeamTable.TABLE_NAME;


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2; //change every time fields  changes
    public static final String DATABASE_NAME = "TeamTable.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
