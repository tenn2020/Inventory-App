package edu.qc.seclass.fim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class inventoryDB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "FloorInventory.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_store";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_CATEGORY = "floor_category";
    private static final String COLUMN_TYPE = "floor_type";
    private static final String COLUMN_SPECIES = "floor_species";
    private static final String COLUMN_COLOR = "floor_color";
    private static final String COLUMN_BRAND = "floor_brand";


    public inventoryDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_CATEGORY + " TEXT, " +
                        COLUMN_TYPE + " TEXT, "+
                        COLUMN_SPECIES + " TEXT, "+
                        COLUMN_COLOR + " TEXT, " +
                        COLUMN_BRAND + "TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i1 > i ){
            db.execSQL("ALTER TABLE "+ TABLE_NAME+ " ADD COLUMN "+ COLUMN_BRAND);
        }
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addFloor(String category, String type, String species, String color){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_TYPE, type);
        cv.put(COLUMN_SPECIES, species);
        cv.put(COLUMN_COLOR, color);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
