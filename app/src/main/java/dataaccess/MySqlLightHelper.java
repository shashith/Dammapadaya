package dataaccess;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by VDARSSH on 5/30/2015.
 */
public class MySqlLightHelper extends SQLiteOpenHelper {

    public static final String CHAPTER= "chapter";
    public static final String CHAPTER_ID = "_id";
    public static final String CHAPTER_NAME = "name";
    public static final String CHAPTER_DESCRIPTION = "description";

    public static final String VERSE= "verse";
    public static final String VERSE_ID = "_id";
    public static final String CHAPTER_NAME_IN_VERSE= "name";
    public static final String VERSE_TEXT = "verse";
    public static final String VERSE_MEANING = "meaning";


    private static final String DATABASE_NAME = "chapter.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + CHAPTER + "(" + CHAPTER_ID
            + " integer primary key autoincrement, " + CHAPTER_NAME
            + " text not null, " + CHAPTER_DESCRIPTION+" text not null);";

    private static final String DATABASE_CREATE_2 = "create table "
            + VERSE + "(" + VERSE_ID
            + " integer primary key autoincrement, " + CHAPTER_NAME_IN_VERSE
            + " text not null, " + VERSE_TEXT+" text not null," + VERSE_MEANING+ " text not null);";

    public MySqlLightHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySqlLightHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + CHAPTER);
        db.execSQL("DROP TABLE IF EXISTS " + VERSE);
        onCreate(db);
    }

}
