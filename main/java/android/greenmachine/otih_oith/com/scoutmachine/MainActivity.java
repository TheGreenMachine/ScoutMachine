package android.greenmachine.otih_oith.com.scoutmachine;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        final ButtonRed buttonRed = (ButtonRed) findViewById(R.id.buttonRed);
        buttonRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

            }

        });
        final ButtonBlue buttonBlue = (ButtonBlue) findViewById(R.id.buttonBlue);
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });

        final ButtonNext buttonNext = (ButtonNext) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });
*/
    }

    public void ButtonRed(View view) {


    }

    public void ButtonBlue(View view) {

    }

    public void ButtonContinue(View view) {
        Intent myIntent = new Intent(MainActivity.this, RobotClass.class);
        startActivity(myIntent);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}


