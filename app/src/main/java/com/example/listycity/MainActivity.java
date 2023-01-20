package com.example.listycity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Button mButtonLoadData;     // add button
    private Button mDeleteItem;     // delete button
    private EditText inputText1;
    private int posHolder;

    private ArrayList<String> mCityList;
    private ArrayAdapter<String> mCityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText1 = findViewById(R.id.enterCityName);
        mButtonLoadData = findViewById(R.id.button_load_data);

        mListView = findViewById(R.id.list_view_city);
        mDeleteItem = findViewById(R.id.button_delete_item);

        mCityList = new ArrayList<>();
        mCityAdapter = new ArrayAdapter<>(this, R.layout.item_city, mCityList);

        mListView.setAdapter(mCityAdapter);

//        mListView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, " ", Toast.LENGTH_SHORT).show();
//            }
//        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
                posHolder = pos;
            }
        });


        mButtonLoadData.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mCityList.add(inputText1.getText().toString());
                mCityAdapter.notifyDataSetChanged();
                inputText1.setText("");
            }
        });

        mDeleteItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                mCityList.remove(posHolder);
                mCityAdapter.notifyDataSetChanged();

            }
        });

    }
}
