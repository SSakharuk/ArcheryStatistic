package com.example.ss.archerystatistic;
import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ss.archerystatistic.util.RequestCodes;


public class MainActivity extends BaseActivity{


    private ArrayAdapter<Person> adapter;
    private ListView listViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> values = dataSource.getAllPersons();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        adapter = new ArrayAdapter<Person>(this,
                android.R.layout.simple_list_item_single_choice, values);
        listViewMain = (ListView) findViewById(R.id.listViewMain);
        listViewMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d("some info ", "itemClick: position = " + position + ", id = "
                        + id);
            }
        });

        listViewMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.d("", "itemSelect: position = " + position + ", id = "
                        + id);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("", "itemSelect: nothing");
            }
        });

            listViewMain.setAdapter(adapter);


            //setListAdapter(adapter);
        }

    public void PersonActivityClick(View view)
    {
        Intent intent = new Intent(this, AddPersonActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, RequestCodes.ADD_PERSON);
    }

    public void ShootSeriesActivityClick(View view) {

        Person person = (Person)listViewMain.getAdapter().getItem(listViewMain.getCheckedItemPosition());

        Log.d("element", "name" + listViewMain.getAdapter().getItem(listViewMain.getCheckedItemPosition()) );

        Toast t = Toast.makeText(getApplicationContext(), listViewMain.getAdapter().getItem(listViewMain.getCheckedItemPosition()).toString(), Toast.LENGTH_LONG);

        t.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RequestCodes.ADD_PERSON)
        {
            if(resultCode == RESULT_OK){
                Toast t = Toast.makeText(getApplicationContext(), "SS THE BEST", Toast.LENGTH_LONG);

                t.show();

                refreshListView();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshListView()
    {
        List<Person> values = dataSource.getAllPersons();
        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this,
                android.R.layout.simple_list_item_1, values);

        listViewMain.setAdapter(adapter);
    }
}
