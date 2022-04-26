package edu.qc.seclass.fim;

import static android.view.View.INVISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.qc.seclass.fim.Adapters.ProductAdapter;
import edu.qc.seclass.fim.models.FloorProduct;

public class ProductActivity extends AppCompatActivity {
    // --Commented out by Inspection (4/26/2022 3:05 PM):private static final String TAG = "MyActivity";

    private ProductAdapter productAdapter;

    inventoryDB myDB;
    // --Commented out by Inspection (4/26/2022 // --Commented out by Inspection (4/26/2022 3:05 PM):3:05 PM):Arr// --Commented out by Inspection (4/26/2022 3:05 PM):ayList<String> floor_id, // --Commented out by Inspection (4/26/2022// --Commented out by Inspection (4/26/2022 3:05 PM): 3:05 PM):floor_category, floor_type, floor_species, floor_color;
    private ArrayList<FloorProduct> floorList;
    FloatingActionButton addProductBtn;
    ImageView backImage;
    ImageButton hierarchySearchView;
    SearchView searchView;
    private String category_filter_input, type_filter_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        this.getSupportActionBar().hide();

        RecyclerView categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        floorList = getFloors();

        //productAdapter.setList(floorList);
        backImage = findViewById(R.id.back_image);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("key");
                        intent.putExtra("key", value);
                }
                startActivity(intent);
                finish();
            }
        });
        addProductBtn = findViewById(R.id.addButton);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("key") != null) {
            String value = extras.getString("key");
            if(value.equals("customer")){
                addProductBtn.setVisibility(INVISIBLE);
            }
        }

        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ProductActivity.this, AddActivity.class);
                startActivity(intent);
                finish();
            }
        });


//        storeDataInArrayList();
//        productAdapter = new ProductAdapter(ProductActivity.this,this ,  floor_id,  floor_category,  floor_type,  floor_species,  floor_color );
        productAdapter = new ProductAdapter(getApplicationContext(), floorList, this);
        categoryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });
        categoryRecyclerView.setAdapter(productAdapter);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }

        });

        hierarchySearchView = findViewById(R.id.hierarchySearch);
        hierarchySearchView.setOnClickListener(new View.OnClickListener() {
            final String[] validCategories = {"Select a Category", "Wood", "Tile", "Stone", "Vinyl", "Laminate"};
            final String[] validWoodTypes = {"Select a Type","Solid", "Engineered", "Bamboo"}; //position 0
            final String[] validTileTypes = {"Select a Type","Porcelain", "Ceramic", "Resin", "Mosaic", "Metal"}; //position 1
            final String[] validStoneTypes = {"Select a Type","Marble", "Pebble", "Slate", "Granite", "Limestone"}; //position 2
            final String[] validVinylTypes = {"Select a Type","Water Resistant", "Water Proof"}; //position 3
            final String[] validLaminateTypes = {"Select a Type","Regular", "Water Resistant"}; //position 4
            Spinner category, type;

            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ProductActivity.this);
                LayoutInflater inflater = ProductActivity.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.hierarchy_search_view, null);
                alertBuilder.setView(dialogView);
                category = dialogView.findViewById(R.id.categoryFilter);
                type = dialogView.findViewById(R.id.typeFilter);
                type.setVisibility(INVISIBLE);
                category.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validCategories));
                category.setSelection(0);
                Button submitButton, cancelButton;
                submitButton = dialogView.findViewById(R.id.submitButton);
                cancelButton = dialogView.findViewById(R.id.cancelButton);
                submitButton.setVisibility(INVISIBLE);
                cancelButton.setVisibility(INVISIBLE);
                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();
                category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        if (position == 0){
                            Toast.makeText(getApplicationContext(), "Please Select a Category", Toast.LENGTH_LONG).show();
                            type.setVisibility(INVISIBLE);
                          }
                        else  {
                            if (position == 2)
                                type.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validTileTypes));
                            if (position == 3)
                                type.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validStoneTypes));
                            if (position == 4)
                                type.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validVinylTypes));
                            if (position == 5)
                                type.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validLaminateTypes));
                            if (position == 1) {
                                type.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validWoodTypes));
                            }
                            category_filter_input = category.getSelectedItem().toString();
                            type.setVisibility(View.VISIBLE);
                            type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                                    type_filter_input = type.getSelectedItem().toString();
                                    if (pos != 0) {

                                        submitButton.setVisibility(View.VISIBLE);
                                        cancelButton.setVisibility(View.VISIBLE);
                                        submitButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                filterList(category_filter_input, type_filter_input);
                                                alertDialog.dismiss();
                                            }
                                        });
                                        cancelButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                alertDialog.dismiss();
                                            }
                                        });
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });
    }


    private void filterList(String text) {
        floorList = getFloors();
        ArrayList<FloorProduct> filterList = new ArrayList<>();
        for(FloorProduct floor : floorList){
            if(floor.getFloorCategory().toLowerCase().contains(text.toLowerCase())){
                filterList.add(floor);
            }
        }
        if(filterList.isEmpty()){
            productAdapter.setFilteredList(filterList); //if no results, list is still updated to show nothing
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else{
            productAdapter.setFilteredList(filterList);
        }
    }

    private void filterList(String category, String type) {
        floorList = getFloors();
        ArrayList<FloorProduct> filterList = new ArrayList<>();
        for(FloorProduct floor : floorList){
            if(floor.getFloorCategory().toLowerCase().contains(category.toLowerCase()) &&
                    floor.getFloorType().toLowerCase().contains(type.toLowerCase())){
                filterList.add(floor);
            }
        }
        if(filterList.isEmpty()){
            productAdapter.setFilteredList(filterList); //if no results, list is still updated to show nothing
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else{
            productAdapter.setFilteredList(filterList);
        }
    }
//    void storeDataInArrayList(){
//        Cursor cursor = myDB.readAllData();
//        if(cursor.getCount() ==  0){
//            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show();
//        }else{
//            while( cursor.moveToNext()){
//                floor_id.add(cursor.getString(0));
//                floor_category.add(cursor.getString(0));
//                floor_type.add(cursor.getString(0));
//                floor_species.add(cursor.getString(0));
//                floor_color.add(cursor.getString(0));
//
//            }
//        }
//
//    }

    private ArrayList<FloorProduct> getFloors(){
        ArrayList<FloorProduct> list = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        myDB = new inventoryDB(ProductActivity.this);
        Cursor cursor = myDB.readAllData();
        while (cursor.moveToNext()) {
            //Log.e(TAG, "" +cursor.getString(0));
            list.add(new FloorProduct(
                    cursor.getInt(0), //id
                    cursor.getString(1), //category
                    cursor.getString(2), //type
                    cursor.getString(3), //species
                    cursor.getString(4)));//color
        }
        return list;
    }
}
