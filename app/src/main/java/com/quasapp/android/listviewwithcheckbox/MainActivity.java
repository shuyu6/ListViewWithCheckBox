package com.quasapp.android.listviewwithcheckbox;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CustomListViewAdapter adapter;
    private ArrayList<ModelAttendee> arrayList;
    private Button addAttendeButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create temporary attendees
        arrayList = new ArrayList<>();
        arrayList.add(new ModelAttendee(1, "shu"));
        arrayList.add(new ModelAttendee(2, "aaa"));
        arrayList.add(new ModelAttendee(3, "bbb"));
        arrayList.add(new ModelAttendee(4, "ccfdc"));
        arrayList.add(new ModelAttendee(5, "cccss"));
        arrayList.add(new ModelAttendee(6, "cccd"));

        //link to the view
        listView = findViewById(R.id.list_view);
        addAttendeButton = findViewById(R.id.add);

        //create a new adapter for listview
        adapter = new CustomListViewAdapter(this, arrayList);

        //set the listview apter
        listView.setAdapter(adapter);

        //when the button is clicked
        addAttendeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray selectedRows = adapter.getSelectedIds();
                if (selectedRows.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < selectedRows.size(); i++) {
                        if (selectedRows.valueAt(i)) {
                            int selectedRowLabel = arrayList.get(selectedRows.keyAt(i)).getId();
                            stringBuilder.append(selectedRowLabel + "\n");
                        }
                    }
                    Toast.makeText(MainActivity.this, "Selected Rows\n" + stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("tag","Selected Rows\n" + stringBuilder.toString());
                }
            }
        });

    }
}
