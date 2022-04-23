package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import edu.qc.seclass.fim.models.FloorProduct;

public class DetailActivity extends AppCompatActivity {

    TextView categoryId, typeId, speciesId, colorId, brandId, quantityId, priceId, sizeId;

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        categoryId = findViewById(R.id.floorCategoryID);
        typeId = findViewById(R.id.floorTypeID);
        speciesId = findViewById(R.id.floorSpeciesID);
        colorId = findViewById(R.id.colorID);
        brandId = findViewById(R.id.brandID);
        quantityId = findViewById(R.id.quantityID);
        priceId = findViewById(R.id.priceID);
        sizeId = findViewById(R.id.sizeID);
        back = findViewById(R.id.backImg);

        FloorProduct floorProduct = Parcels.unwrap(getIntent().getParcelableExtra("floor"));

        categoryId.setText(floorProduct.getFloorCategory());
        typeId.setText(floorProduct.getFloorType());
        speciesId.setText(floorProduct.getFloorSpecies());
        colorId.setText(floorProduct.getFloorColor());


        if(floorProduct.getFloorCategory().equals("Tile")){
            brandId.setText("Armstrong");
            priceId.setText("$45.00");
            sizeId.setText("12");
        }else if(floorProduct.getFloorCategory().equals("Wood")){
            brandId.setText("Shaw");
            priceId.setText("$40.00");
            sizeId.setText("18");
        }else if(floorProduct.getFloorCategory().equals("Stone")){
            brandId.setText("Tarkett");
            priceId.setText("$75.00");
            sizeId.setText("16");
        }else if(floorProduct.getFloorCategory().equals("Vinyl")){
            brandId.setText("Mannington");
            priceId.setText("$15.00");
            sizeId.setText("10");
        }else if(floorProduct.getFloorCategory().equals("Laminate")) {
            brandId.setText("Mohawk");
            priceId.setText("$70.00");
            sizeId.setText("8");
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(DetailActivity.this, ProductActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}