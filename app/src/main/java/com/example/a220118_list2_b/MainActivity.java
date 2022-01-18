package com.example.a220118_list2_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mData = new ArrayList<>();
    private ListView mList1;
    private ListView mList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData.add("수성");
        mData.add("금성");
        mData.add("지구");
        mData.add("화성");
        mData.add("목성");
        mData.add("토성");
        mData.add("천왕성");
        mData.add("해왕성");

        mList1 = (ListView)findViewById(R.id.list1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mData);
        mList1.setAdapter(adapter1);

        mList2 = (ListView)findViewById(R.id.list2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.earth, android.R.layout.simple_list_item_1);
        mList2.setAdapter(adapter2);

        mList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        mList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] arrData = getResources().getStringArray(R.array.earth);
                Toast.makeText(MainActivity.this, arrData[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}