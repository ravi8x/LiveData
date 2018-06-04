package com.droid5.livedata.ui.transform;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droid5.livedata.R;
import com.droid5.livedata.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransformFragment extends Fragment {

    @BindView(R.id.full_address)
    TextView tvFullAddress;

    @BindView(R.id.name)
    TextView tvName;

    private TransformViewModel mViewModel;

    public static TransformFragment newInstance() {
        return new TransformFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.transform_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TransformViewModel.class);

        mViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                tvName.setText(user.getName());
            }
        });

        mViewModel.getFullAddress().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvFullAddress.setText(s);
            }
        });
    }

    /**
     * Updating user address. You can see full address reflected on
     * the UI automatically as full address is observed
     */
    @OnClick(R.id.btn_update_address)
    void updateAddress() {
        User user = prepareUser();
        mViewModel.setUser(user);
    }

    private User prepareUser() {
        User u = new User();
        u.setName("Ravi Tamada");

        u.setCountry("India");
        u.setStreetAddress("Flat 202, MV Golden Apartments, KPHB");
        u.setCity("Hyderabad");
        u.setPinCode("500085");

        u.setPrimaryMobile("8930029993");
        u.setSecondaryMobile("9200003944");
        return u;
    }

}
