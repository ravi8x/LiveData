package com.droid5.livedata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.droid5.livedata.ui.scorecard.ScoreCardFragment;

public class ScoreCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        applyFragmentBackgroundColors();

        Toast.makeText(getApplicationContext(), getString(R.string.msg_toast_tap_view), Toast.LENGTH_LONG).show();
    }

    /**
     * Applying random background color to four fragments
     * to differentiate them on the screen
     */
    private void applyFragmentBackgroundColors() {
        int[] rainbow = getResources().getIntArray(R.array.colors);

        for (int i = 1; i <= rainbow.length; i++) {
            int id = getResources().getIdentifier("fragment" + i, "id", getPackageName());
            ScoreCardFragment scoreCardFragment = (ScoreCardFragment) getSupportFragmentManager().findFragmentById(id);
            FrameLayout frameLayout = (FrameLayout) scoreCardFragment.getView();
            frameLayout.setBackgroundColor(rainbow[i - 1]);
        }
    }
}
