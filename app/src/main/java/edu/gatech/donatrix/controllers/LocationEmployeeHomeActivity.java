package edu.gatech.donatrix.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import edu.gatech.donatrix.R;

public class LocationEmployeeHomeActivity extends AppCompatActivity {

    private int locationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_location_employee);

        Intent intent = getIntent();
        locationId = intent.getIntExtra("location_id", 0);
    }

    public void onLogoutPressed(View view) {
        finish();
    }

    public void onAddItemPressed(View view) {
        Intent intent = new Intent(LocationEmployeeHomeActivity.this, AddItemActivity.class);
        intent.putExtra("location_id", locationId);
        startActivity(intent);
    }

    public void onShowItemsButtonPressed(View view) {
        Intent intent = new Intent(LocationEmployeeHomeActivity.this, ItemListActivity.class);
        intent.putExtra("location_id", locationId);
        intent.putExtra("all_items", false);
        startActivity(intent);
    }

    public void onShowAllItemsPressed(View view) {
        Intent intent = new Intent(LocationEmployeeHomeActivity.this, ItemListActivity.class);
        intent.putExtra("location_id", locationId);
        intent.putExtra("all_items", true);
        startActivity(intent);
    }

    public void onSearchItemsPressed(View view) {
        try {
            Intent intent = new Intent(this, ItemSearchActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Log.d("Donatrix", e.getMessage());
        }
    }

    public void onLocationListPressed(View view) {
        Intent intent = new Intent(this, LocationListActivity.class);
        startActivity(intent);
    }
}
