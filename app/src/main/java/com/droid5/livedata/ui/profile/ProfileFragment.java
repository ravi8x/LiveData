package com.droid5.livedata.ui.profile;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droid5.livedata.R;
import com.droid5.livedata.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();
    private ProfileViewModel mViewModel;
    CallActionsAdapter mAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(ProfileViewModel.class);

        mViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Log.e(TAG, "Name: " + user.getName());
                Log.e(TAG, "Email: " + user.getEmail());
                // Log.d(TAG, "Phones: " + user.getPhoneNumbers().);
                mAdapter.setData(user.getPhoneNumbers());
            }
        });

        mAdapter = new CallActionsAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    class CallActionsAdapter extends RecyclerView.Adapter<CallActionsAdapter.MyViewHolder> {

        private List<String> actions;

        public CallActionsAdapter(){}

        public class MyViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.call_action)
            TextView tvAction;

            public MyViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

        @NonNull
        @Override
        public CallActionsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_call_action, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CallActionsAdapter.MyViewHolder holder, int position) {
            holder.tvAction.setText(actions.get(position));
        }

        @Override
        public int getItemCount() {
            Log.e(TAG, "getItemCount: " + actions.size());
            return actions.size();
        }

        public void setData(List<String> actions) {
            this.actions = actions;
            notifyDataSetChanged();
        }
    }
}
