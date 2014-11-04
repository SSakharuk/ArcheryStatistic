package com.example.ss.archerystatistic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.ss.archerystatistic.util.RequestCodes;

import java.util.Date;


public class AddPersonActivity extends BaseActivity {
    private EditText textName;
    private EditText textAge;
    private EditText textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        textName = (EditText)findViewById(R.id.textName);
        textAge = (EditText)findViewById(R.id.textAge);
        textEmail = (EditText)findViewById(R.id.textEmail);

    }


    public void addPersonClick(View view) {
        dataSource.createPerson(textName.getText().toString(), Integer.parseInt(textAge.getText().toString()), textEmail.getText().toString(), new Date(), new Date());
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
       // dataSource.close();
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_person, menu);
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
}
