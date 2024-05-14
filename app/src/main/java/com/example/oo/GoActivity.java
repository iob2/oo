package com.example.oo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GoActivity extends AppCompatActivity {

    EditText searchEditText;
    Button searchButton;
    ListView resultsListView;
    ArrayAdapter<String> adapter;
    List<String> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        resultsListView = findViewById(R.id.resultsListView);

        // تهيئة المحول مع قائمة فارغة
        productList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productList);
        resultsListView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString().trim();
                searchProducts(query);
            }
        });
    }

    private void searchProducts(String query) {
        productList.clear();
        if (query.equalsIgnoreCase("شارلت تربري")) {
            productList.add("NYX");
            productList.add("ELF");
            productList.add("REVOLUTION");
        }
        adapter.notifyDataSetChanged();
    }
}
