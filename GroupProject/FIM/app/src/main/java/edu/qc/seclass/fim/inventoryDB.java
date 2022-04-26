package edu.qc.seclass.fim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class inventoryDB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "FloorInventory.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "my_store";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_CATEGORY = "floor_category";
    private static final String COLUMN_TYPE = "floor_type";
    private static final String COLUMN_SPECIES = "floor_species";
    private static final String COLUMN_COLOR = "floor_color";
    private static final String COLUMN_BRAND = "floor_brand";
    private static final String COLUMN_QUANTITY = "floor_quantity";



    public inventoryDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " ("
                        +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        +COLUMN_CATEGORY + " TEXT, "
                        +COLUMN_TYPE + " TEXT, "
                        +COLUMN_SPECIES + " TEXT, "
                        +COLUMN_COLOR + " TEXT, "
                        +COLUMN_BRAND + " TEXT, "
                        +COLUMN_QUANTITY + " INTEGER);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion ){
            db.execSQL("ALTER TABLE "+ TABLE_NAME+ " ADD COLUMN "+ COLUMN_BRAND);
            db.execSQL("ALTER TABLE "+ TABLE_NAME+ " ADD COLUMN "+ COLUMN_QUANTITY);
        }
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    void addFloor(String category, String type, String species, String color, Integer quantity){
        String brand = null;
        if(category.equals("Tile")){
            brand = "Armstrong";
        }
        else if(category.equals("Wood")){
            brand = "Shaw";
        }
        else if(category.equals("Stone")){
            brand = "Tarkett";
        }
        else if(category.equals("Vinyl")){
            brand = "Mannington";
        }
        else if(category.equals("Laminate")){
            brand = "Mohawk";
        }
        
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_TYPE, type);
        cv.put(COLUMN_SPECIES, species);
        cv.put(COLUMN_COLOR, color);
        cv.put(COLUMN_BRAND, brand);
        cv.put(COLUMN_QUANTITY, quantity);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Boolean hasFloor(String categoryValue, String typeValue, String speciesValue, String colorValue){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("SELECT * FROM %s WHERE %s LIKE \"%s\" AND  %s LIKE \"%s\" AND %s LIKE \"%s\"", TABLE_NAME, COLUMN_CATEGORY, categoryValue
        , COLUMN_TYPE, typeValue, COLUMN_COLOR, colorValue);
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        else {
            cursor.close();
            return true;
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
