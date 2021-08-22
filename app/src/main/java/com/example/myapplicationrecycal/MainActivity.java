package com.example.myapplicationrecycal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycla);
        recyclerView.setHasFixedSize(true);  // every item has fixd size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>(); // recycle view eken display karanna ona okkama methana thiyenne

        for (int i = 0 ; i<=1000;i++)
        {
            ListItem listItem = new ListItem("text1",""+i); // venama haduwa java class eke objevt eka

            listItems.add(listItem);
        }

        adapter = new MyAdepter(listItems,this);

        recyclerView.setAdapter(adapter);
    }
}