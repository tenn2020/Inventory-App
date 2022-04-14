package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.fim.Adapters.ProductAdapter;
import edu.qc.seclass.fim.models.FloorProduct;

public class ProductActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    private RecyclerView categoryRecyclerView;
    private ProductAdapter productAdapter;

    inventoryDB myDB;
    ArrayList<String> floor_id, floor_category, floor_type, floor_species, floor_color;
    private ArrayList<FloorProduct> floorList;
    FloatingActionButton addProductBtn;
    ImageView backImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        this.getSupportActionBar().hide();


        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        floorList = getFloors();
//        FloorProduct floor1 = new FloorProduct();
//        floor1.setCategory("Wood");

//        floorList.add(floor1);
//        floorList.add(floor1);

        //productAdapter.setList(floorList);
        backImage = findViewById(R.id.back_image);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        addProductBtn = findViewById(R.id.addButton);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            if(value.equals("customer")){
                addProductBtn.setVisibility(View.INVISIBLE);
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

//        myDB = new inventoryDB(ProductActivity.this);
//        floor_id = new ArrayList<>();
//        floor_category = new ArrayList<>();
//        floor_type = new ArrayList<>();
//        floor_species = new ArrayList<>();
//        floor_color = new ArrayList<>();

//        storeDataInArrayList();
//        productAdapter = new ProductAdapter(ProductActivity.this,this ,  floor_id,  floor_category,  floor_type,  floor_species,  floor_color );
        productAdapter = new ProductAdapter(getApplicationContext(), floorList);
        categoryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });
        categoryRecyclerView.setAdapter(productAdapter);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        ArrayList<String> data = new ArrayList<String>();
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
