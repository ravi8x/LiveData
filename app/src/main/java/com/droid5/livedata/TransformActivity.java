package com.droid5.livedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.droid5.livedata.ui.transform.TransformFragment;

public class TransformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transform_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TransformFragment.newInstance())
                    .commitNow();
        }
    }
}
