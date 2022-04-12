package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.fim.Adapters.ProductAdapter;
import edu.qc.seclass.fim.models.FloorProduct;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private ProductAdapter productAdapter;

    FloatingActionButton addProductBtn;
    private List <FloorProduct> floorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        this.getSupportActionBar().hide();

        floorList = new ArrayList<>();

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productAdapter = new ProductAdapter((this));
        categoryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });
        categoryRecyclerView.setAdapter(productAdapter);

        FloorProduct floor1 = new FloorProduct();
        floor1.setCategory("Wood");

        floorList.add(floor1);
        floorList.add(floor1);

        productAdapter.setList(floorList);

        addProductBtn = findViewById(R.id.addButton);
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ProductActivity.this, AddActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}