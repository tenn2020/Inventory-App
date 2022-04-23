package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class AddActivity extends AppCompatActivity {

    Spinner category_input, type_input, species_input, color_input;
    Button add_button;
    ImageView backButton;

    //Create arraylists to store the dependent spinner information
    String[] validCategories = {"Select a Category", "Wood", "Tile", "Stone", "Vinyl", "Laminate"};

    String[] validWoodTypes = {"Select a Type","Solid", "Engineered", "Bamboo"}; //position 0
    String[] validTileTypes = {"Select a Type","Porcelain", "Ceramic", "Resin", "Mosaic", "Metal"}; //position 1
    String[] validStoneTypes = {"Select a Type","Marble", "Pebble", "Slate", "Granite", "Limestone"}; //position 2
    String[] validVinylTypes = {"Select a Type","Water Resistant", "Water Proof"}; //position 3
    String[] validLaminateTypes = {"Select a Type","Regular", "Water Resistant"}; //position 4

    String[] validSpecies = {"Select a Species","Oak", "Hickory", "Maple", "Teak", "Ash"};
    String[] noSpecies = {"N/A"}; //If category is not wood, N/A will be the species

    String[] validColors = {"Select a Color","Red", "Blue", "Beige", "Brown", "White"};

    //Spinner Adapters
    ArrayAdapter<String> categoryAdapter;
    ArrayAdapter<String> typeAdapter;
    ArrayAdapter<String> noSpeciesAdapter;
    ArrayAdapter<String> speciesAdapter;
    ArrayAdapter<String> colorAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //Add Button
        add_button = findViewById(R.id.btnPush);
        backButton = findViewById(R.id.backBtn);
        //Spinners
        category_input = findViewById(R.id.categoryEdit);
        type_input = findViewById(R.id.typeEdit);
        species_input = findViewById(R.id.speciesEdit);
        color_input = findViewById(R.id.colorEdit);

        type_input.setVisibility(View.GONE);
        color_input.setVisibility(View.GONE);
        species_input.setVisibility(View.GONE);

        categoryAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validCategories);
        category_input.setAdapter(categoryAdapter);
        category_input.setPrompt("Select a Category");

        noSpeciesAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, noSpecies);
        String value = "customer";
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(AddActivity.this, ProductActivity.class);
                //intent.putExtra("key", value);
                startActivity(intent);
                finish();

            }
        });


        //Read the category selected, then show valid types
        category_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> category, View view, int position, long id) {

                if (position == 1){ //Wood
                    typeAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validWoodTypes);
                    speciesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validSpecies);
                    colorAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validColors);
                    species_input.setVisibility(View.VISIBLE);
                    type_input.setVisibility(View.VISIBLE);
                    color_input.setVisibility(View.VISIBLE);
                }
                else if (position == 2){ //Tile
                    typeAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validTileTypes);
                    speciesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, noSpecies);
                    colorAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validColors);
                    species_input.setVisibility(View.GONE);
                    type_input.setVisibility(View.VISIBLE);
                    color_input.setVisibility(View.VISIBLE);
                }
                else if (position == 3){ //Stone
                    typeAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validStoneTypes);
                    speciesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, noSpecies);
                    colorAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validColors);
                    species_input.setVisibility(View.GONE);
                    type_input.setVisibility(View.VISIBLE);
                    color_input.setVisibility(View.VISIBLE);
                }
                else if (position == 4){ //Vinyl
                    typeAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validVinylTypes);
                    speciesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, noSpecies);
                    colorAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validColors);
                    species_input.setVisibility(View.GONE);
                    type_input.setVisibility(View.VISIBLE);
                    color_input.setVisibility(View.VISIBLE);
                }
                else if (position == 5){ //Laminate
                    typeAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validLaminateTypes);
                    speciesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, noSpecies);
                    colorAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, validColors);
                    species_input.setVisibility(View.GONE);
                    type_input.setVisibility(View.VISIBLE);
                    color_input.setVisibility(View.VISIBLE);
                }

                type_input.setAdapter(typeAdapter);
                color_input.setAdapter(colorAdapter);
                species_input.setAdapter(speciesAdapter);
                type_input.setPrompt("Select a Type");
                color_input.setPrompt("Select a Color");
                species_input.setPrompt("Select a Species");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String categoryInput = category_input.getSelectedItem().toString();
                String typeInput = type_input.getSelectedItem().toString();
                String speciesInput = species_input.getSelectedItem().toString();
                String colorInput = color_input.getSelectedItem().toString();

                if (categoryInput.equalsIgnoreCase("Select a Category")) {
                    Toast.makeText(getApplicationContext(), "Please Select a Valid Category", Toast.LENGTH_SHORT).show();
                }
                else if(typeInput.equalsIgnoreCase("Select a Type")){
                    Toast.makeText(getApplicationContext(), "Please Select a Valid Type", Toast.LENGTH_SHORT).show();

                }
                else if (speciesInput.equalsIgnoreCase("Select a Species")){
                    Toast.makeText(getApplicationContext(), "Please Select a Valid Species", Toast.LENGTH_SHORT).show();

                }
                else if (colorInput.equalsIgnoreCase("Select a Color")) {
                    Toast.makeText(getApplicationContext(), "Please Select a Valid Color", Toast.LENGTH_SHORT).show();
                }

                else {
                    //Show a dialog asking them to confirm the floor addition
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddActivity.this);
                    alertBuilder.setMessage(String.format("Category: %s\nType:%s\nSpecies:%s\nColor:%s",
                            categoryInput, typeInput, speciesInput, colorInput)).setTitle("Are you sure you want to add this floor?");
                    alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            inventoryDB db = new inventoryDB(AddActivity.this);
                            db.addFloor(category_input.getSelectedItem().toString().trim(),
                                    type_input.getSelectedItem().toString().trim(),
                                    species_input.getSelectedItem().toString().trim(),
                                    color_input.getSelectedItem().toString().trim());
                            Toast.makeText(getApplicationContext(), "Added Successfully!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog confirmFloor = alertBuilder.create();
                    confirmFloor.show();
                }
            }
        });

    }

}