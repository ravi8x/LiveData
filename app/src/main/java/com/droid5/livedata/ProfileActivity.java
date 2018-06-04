package com.droid5.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droid5.livedata.model.User;
import com.droid5.livedata.ui.profile.ProfileFragment;
import com.droid5.livedata.ui.profile.ProfileViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.backdrop)
    ImageView backdrop;

    @BindView(R.id.profile_image)
    ImageView profileImage;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.country)
    TextView location;

    private ProfileViewModel mViewModel;

    // TODO - AppBar can be maintained with a separate ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance())
                    .commitNow();
        }

        mViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);

        mViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                renderActionBar(user);
            }
        });
    }

    private void renderActionBar(User user) {
        Glide.with(this).load(user.getProfileCoverImage()).into(backdrop);
        Glide.with(this).load(user.getProfileImageUrl()).apply(RequestOptions.circleCropTransform()).into(profileImage);
        name.setText(user.getName());
        location.setText(user.getCountry());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_shared_fragments) {
            startActivity(new Intent(ProfileActivity.this, ScoreCardActivity.class));
            return true;
        }

        if (item.getItemId() == R.id.action_transforms_fragments) {
            startActivity(new Intent(ProfileActivity.this, TransformActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
