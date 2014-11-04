package com.example.ss.archerystatistic;

import android.app.ListActivity;
import android.os.Bundle;

/**
 * Created by SS on 04.11.2014.
 */
public class BaseListActivity extends ListActivity {
    protected ArcheryDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource = new ArcheryDataSource(this);
        dataSource.open();
    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}
