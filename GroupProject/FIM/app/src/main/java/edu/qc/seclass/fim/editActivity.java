package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.parceler.Parcels;

import edu.qc.seclass.fim.models.FloorProduct;

public class editActivity extends AppCompatActivity {

    EditText category_input, type_input, species_input, color_input;
    EditText quantity_input;
    Button update_button;
    String  category, type, species, color;
    Integer quantity, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        category_input = findViewById(R.id.category_input);
        type_input = findViewById(R.id.type_input);
        species_input = findViewById(R.id.species_input);
        color_input = findViewById(R.id.color_input);
        quantity_input = findViewById(R.id.quantity_input);
        update_button = findViewById(R.id.updateBtn);

        FloorProduct floorProduct = Parcels.unwrap(getIntent().getParcelableExtra("floor"));

        id = floorProduct.getFloorID();
        category = floorProduct.getFloorCategory();
        type = floorProduct.getFloorType();
        color = floorProduct.getFloorColor();
        quantity = floorProduct.getQuantity();
        species = floorProduct.getFloorSpecies();

        category_input.setText(category);
        type_input.setText(type);
        color_input.setText(color);
        quantity_input.setText(String.valueOf(quantity));
        species_input.setText(species);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("EditActivity", category+ type+ color+ quantity+ species);
                category = category_input.getText().toString();
                type = type_input.getText().toString();
                color = color_input.getText().toString();
                quantity = Integer.parseInt(quantity_input.getText().toString());
                species = species_input.getText().toString();
                inventoryDB myDB = new inventoryDB(editActivity.this);
                myDB.updateData(String.valueOf(id), category, type, species, color, quantity );


            }
        });


    }
}