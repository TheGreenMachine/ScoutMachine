package android.greenmachine.otih_oith.com.scoutmachine;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import static android.greenmachine.otih_oith.com.scoutmachine.FeedReaderDbHelper.DATABASE_NAME;

public class Driver_Rating extends AppCompatActivity {

    private FeedReaderDbHelper mDbHelper;
    private RadioButton radioButtonRate1;
    private RadioButton radioButtonRate2;
    private RadioButton radioButtonRate3;
    private RadioButton radioButtonRate4;
    private RadioButton radioButtonRate5;

    private RadioButton radioButtonP1;
    private RadioButton radioButtonP2;
    private RadioButton radioButtonP3;
    private RadioButton radioButtonP4;
    private RadioButton radioButtonP5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver__rating);
        radioButtonRate1 = (RadioButton) findViewById(R.id.radioButtonRate1);
        radioButtonRate2 = (RadioButton) findViewById(R.id.radioButtonRate2);
        radioButtonRate3 = (RadioButton) findViewById(R.id.radioButtonRating3);
        radioButtonRate4 = (RadioButton) findViewById(R.id.radioButtonRating4);
        radioButtonRate5 = (RadioButton) findViewById(R.id.radioButtonRate5);

        radioButtonP1 = (RadioButton) findViewById(R.id.radioButtonP1);
        radioButtonP2 = (RadioButton) findViewById(R.id.radioButtoP2);
        radioButtonP3 = (RadioButton) findViewById(R.id.radioButtonP3);
        radioButtonP4 = (RadioButton) findViewById(R.id.radioButtonP4);
        radioButtonP5 = (RadioButton) findViewById(R.id.radioButtonP5);

        mDbHelper = new FeedReaderDbHelper(this);
    }

    public void lastPart(View v) {

    SQLiteDatabase db = mDbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_PILOT_RATING,pilotPerform.toString());
        values.put(SQLiteOpenHelper.TeamTableContract.TeamTable.COLUMN_NAME_DRIVER_PERFORM,driverPerform.toString());

}
    public void copyDBToSDCard(View v) {



        // switch (v.getId()) {
        //case R.id.buttonSave:
        exportDB();
        //break;
        //}
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//android.greenmachine.otih_oith.com.scoutmachine//databases//TeamTables.db}";
                String backupDBPath = "TeamTables.db"; //             /storage/emulated/0/Download/
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
                Toast.makeText(getBaseContext(), backupDB.toString(), Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
/*

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                exportDB();
                break;

        }
    }
    */


    private void exportDB() {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;
        String currentDBPath = "/data/" + "android.greenmachine.otih_oith.com.scoutmachine" + "/databases/" + DATABASE_NAME;
        String backupDBPath = DATABASE_NAME;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(this, "DB Exported!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        /* //n/a working right now
        try {
            InputStream myInput = new FileInputStream("/data/data/android.greenmachine.otih_oith.com.scoutmachine/databases/"+DATABASE_NAME);

            File file = new File(Environment.getExternalStorageDirectory().getPath()+"/"+DATABASE_NAME);
            if (!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                   // Log.i("FO","File creation failed for " + file);
                }
            }


            OutputStream myOutput = new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/"+DATABASE_NAME);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
            }

            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
           // Log.i("FO","copied");

        } catch (Exception e) {
        //    Log.i("FO","exception="+e);
        }

*/

   String driverPerform = "";

    public void RadioButtonClicked(View view) {

        //This variable will store whether the user was male or female
        

        // Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonRate1:
                if (checked)
                    driverPerform = "1";
                break;
            case R.id.radioButtonRate2:
                if (checked)
                    driverPerform = "2";
                break;
            case R.id.radioButtonRating3:
                if (checked)
                    driverPerform = "3";
                break;
            case R.id.radioButtonRating4:
                if (checked)
                    driverPerform = "4";
                break;
            case R.id.radioButtonRate5:
                if (checked)
                    driverPerform = "5";
                break;
        }


    }
   String pilotPerform ="";

    public void RadioButtonClickedPilot(View view) {

        //This variable will store whether the user was male or female


        // Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonP1:
                if (checked)
                    pilotPerform = "1";
                break;
            case R.id.radioButtoP2:
                if (checked)
                    pilotPerform = "2";
                break;
            case R.id.radioButtonP3:
                if (checked)
                    pilotPerform= "3";
                break;
            case R.id.radioButtonP4:
                if (checked)
                    pilotPerform = "4";
                break;
            case R.id.radioButtonP5:
                if (checked)
                    pilotPerform = "5";
                break;
        }


    }
}



