package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        quantityId.setText(floorProduct.getQuantity().toString());
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
        Integer sqft = Integer.parseInt(sizeId.getText().toString()) * Integer.parseInt(quantityId.getText().toString());
        String quantity = sqft.toString() + " sqft";
        quantityId.setText(quantity);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(DetailActivity.this, ProductActivity.class);
                intent.putExtra("key", getIntent().getExtras().getString("key"));
                startActivity(intent);
                finish();
            }
        });

        View deleteView = findViewById(R.id.layoutBelow);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("key") != null) {
            String value = extras.getString("key");
            if(!value.equals("employee")){
                deleteView.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void deleteFloor(View view){
        inventoryDB db = new inventoryDB(getApplicationContext());
        String sql = String.format("DELETE FROM my_store WHERE " +
                "floor_category = \"%s\" " +
                "AND  floor_type = \"%s\" " +
                "AND floor_species = \"%s\" " +
                "AND floor_color = \"%s\"",
                this.categoryId.getText(), this.typeId.getText(), this.speciesId.getText(), this.colorId.getText());
        long oldRowCount = DatabaseUtils.queryNumEntries(db.getWritableDatabase(), "my_store");
        db.getWritableDatabase().execSQL(sql);
        long newRowCount = DatabaseUtils.queryNumEntries(db.getWritableDatabase(), "my_store");
        if (newRowCount < oldRowCount){
            Toast.makeText(getApplicationContext(),"Floor successfully deleted.",Toast.LENGTH_LONG).show();
        }
    }
}