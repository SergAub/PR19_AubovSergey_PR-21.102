package com.example.pr19_aubovsergey_pr_21102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ForDlg extends AppCompatActivity implements  Removable{

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_dlg);

        ListView animalsList = findViewById(R.id.animalsList);
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Panther");
        animals.add("Wolf");
        animals.add("Elephant");
        animals.add("Tiger");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        animalsList.setAdapter(adapter);

        animalsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedPhone = adapter.getItem(position);
                DialogClass dialog = new DialogClass();
                Bundle args = new Bundle();
                args.putString("animal", selectedPhone);
                dialog.setArguments(args);
                dialog.show(getSupportFragmentManager(), "custom");
            }
        });
    }

    public void remove(String name) {
        adapter.remove(name);
    }
}