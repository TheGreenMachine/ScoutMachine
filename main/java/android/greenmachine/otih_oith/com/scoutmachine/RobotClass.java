package android.greenmachine.otih_oith.com.scoutmachine;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.greenmachine.otih_oith.com.scoutmachine.R.id.editTextBalls;
import static android.greenmachine.otih_oith.com.scoutmachine.R.id.editTextNumberofGears;
import static android.greenmachine.otih_oith.com.scoutmachine.R.id.editTextPoints;
import static android.greenmachine.otih_oith.com.scoutmachine.R.id.editTextTeam;
import android.greenmachine.otih_oith.com.scoutmachine.Driver_Rating;

public class RobotClass extends AppCompatActivity  {

    private FeedReaderDbHelper mDbHelper;
    private EditText teamEditText;
    private EditText pointsEditText;
    private EditText gearsEditText;
    private EditText ballEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_class);
        teamEditText = (EditText) findViewById(R.id.editTextTeam);
        pointsEditText = (EditText) findViewById(R.id.editTextPoints);
        gearsEditText = (EditText) findViewById(R.id.editTextNumberofGears);
        ballEditText = (EditText) findViewById(R.id.editTextBalls);
        mDbHelper = new FeedReaderDbHelper(this);
    }


    public void ButtonNext(View view) {
// Gets the data repository in write mode

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_TEAM_NUMBER,teamEditText.getText().toString());
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_BAllS,ballEditText.getText().toString());
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_GEARS,gearsEditText.getText().toString());
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_POINTS,pointsEditText.getText().toString());
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_WALK,"");
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_DEFENCE,"");

        //  values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_TITLE, title);
        //   values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_SUBTITLE, subtitle);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(SQLiteOpenHelper.TeamTableContract.TeamTable.TABLE_NAME, null, values);
        Toast.makeText(this, "newRowId" + String.valueOf(newRowId), Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "Team" + teamEditText.getText().toString(), Toast.LENGTH_SHORT).show();

        Intent myIntent = new Intent(RobotClass.this, Driver_Rating.class);
        startActivity(myIntent);

    }








/*
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);

        */


}
