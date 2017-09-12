package com.example.user.searchlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String items[];
    ArrayList<String> listitems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);
        editText=(EditText)findViewById(R.id.txtsearch);
        initlilst();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                if(s.toString().equals(""))
                {
                    //reset listview
                   initlilst();
                }
                else
                {
                    //perform search
                    searchItem(s.toString());

                }

            }



            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    public void searchItem(String textToSearch)
    {
        for (String item:items)
        {
            if(!item.contains(textToSearch))
            {
                listitems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initlilst()
    {
        items=new String[]{"C","C++","Java","Angular 2", "JavaScript"};
        listitems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,listitems);
        listView.setAdapter(adapter);
    }
}
