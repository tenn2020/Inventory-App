package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    Button customerBtn;
    Button employeeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        customerBtn = findViewById(R.id.customerBtn);
        employeeBtn = findViewById(R.id.employeeBtn);
        customerBtn.setOnClickListener(new View.OnClickListener() {
            String value = "customer";
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("key", value);
                startActivity(intent);
                finish();
            }
        });
        employeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = "employee";
                final Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("key", value);
                startActivity(intent);
                finish();
            }
        });


    }
}