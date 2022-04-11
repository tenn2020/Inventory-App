package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.fim.Adapters.ProductAdapter;
import edu.qc.seclass.fim.models.FloorCategory;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private ProductAdapter productAdapter;

    private List <FloorCategory> floorCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        this.getSupportActionBar().hide();

        floorCategoryList = new ArrayList<>();
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productAdapter = new ProductAdapter((this));
        categoryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });
        categoryRecyclerView.setAdapter(productAdapter);

        FloorCategory category1 = new FloorCategory();
        category1.setCategory("Wood");

        floorCategoryList.add(category1);
        floorCategoryList.add(category1);

        productAdapter.setList(floorCategoryList);

    }
}