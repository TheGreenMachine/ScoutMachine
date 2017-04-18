package android.greenmachine.otih_oith.com.scoutmachine;

import android.provider.BaseColumns;

/**
 * Created by User on 3/18/2017.
 */

public class SQLiteOpenHelper {


    public final class TeamTableContract {
        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private TeamTableContract() {
        }

        /* Inner class that defines the table contents */
        public class TeamTable implements BaseColumns {
            public static final String TABLE_NAME = "TeamTable";
            public static final String COLUMN_NAME_TEAM_NUMBER = "Number";
            public static final String COLUMN_NAME_POINTS = "POINTS";
            public static final String COLUMN_NAME_WALK = "WALKROPE";
            public static final String COLUMN_NAME_DEFENCE = "Defenable";
            public static final String COLUMN_NAME_GEARS = "Gears";
            public static final String COLUMN_NAME_BAllS = "Balls";
            public static final String COLUMN_NAME_PILOT_RATING = "Pilot";
            public static final String COLUMN_NAME_DRIVER_PERFORM = "Driver";
        }
    }

}