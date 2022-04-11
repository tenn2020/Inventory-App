package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.fim.Adapters.ProductAdapter;
import edu.qc.seclass.fim.models.FloorProduct;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private ProductAdapter productAdapter;

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

    }
}