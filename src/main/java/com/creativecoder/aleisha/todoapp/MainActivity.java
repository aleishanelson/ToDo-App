package com.creativecoder.aleisha.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lvItems;
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById (R.id.lvItems);
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("Item 1");
        items.add("Item 2");
        setUpListViewListener();

    }

    //create functionality for button to add item to _todo list
    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
    }


    //method to remove item from list
    //create listener to listen/wait until user performs action (e.g. clicks and holds on item in list) then remove that item.
    public void setUpListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    //create method within here to decide what happens when the user clicks and holds
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View item, int pos, long id) {
                        items.remove(pos); //remove item from the exact position that was clicked
                        itemsAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );
    }
}
