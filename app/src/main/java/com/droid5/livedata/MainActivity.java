package com.droid5.livedata;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        applyFragmentBackgroundColors();
    }

    /**
     * Applying random background color to four fragments
     */
    private void applyFragmentBackgroundColors() {
        int[] rainbow = getResources().getIntArray(R.array.colors);

        for (int i = 1; i <= rainbow.length; i++) {
            int id = getResources().getIdentifier("fragment" + i, "id", getPackageName());
            ScoreFragment scoreFragment = (ScoreFragment) getSupportFragmentManager().findFragmentById(id);
            FrameLayout frameLayout = (FrameLayout) scoreFragment.getView();
            frameLayout.setBackgroundColor(rainbow[i - 1]);
        }
    }
}
