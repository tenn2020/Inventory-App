package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity {

    EditText category_input, type_input, species_input, color_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        category_input = findViewById(R.id.categoryEdit);
        type_input = findViewById(R.id.typeEdit);
        species_input = findViewById(R.id.speciesEdit);
        color_input = findViewById(R.id.colorEdit);
        add_button = findViewById(R.id.btnPush);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventoryDB db = new inventoryDB(AddActivity.this);
                db.addFloor(category_input.getText().toString().trim(),
                        type_input.getText().toString().trim(),
                        species_input.getText().toString().trim(),
                        color_input.getText().toString().trim());
            }
        });

    }

}