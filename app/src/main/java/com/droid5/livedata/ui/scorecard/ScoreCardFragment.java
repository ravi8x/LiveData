package com.droid5.livedata.ui.scorecard;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droid5.livedata.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScoreCardFragment extends Fragment {

    @BindView(R.id.tv_score)
    TextView txtScore;

    private ScoreCardViewModel viewModel;

    public ScoreCardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score_card, container, false);
        ButterKnife.bind(this, view);

        // Providing context is more important here
        // `this` won't sync the data across all fragments
        // `getActivity()` - sync the data across all fragments

        viewModel = ViewModelProviders.of(getActivity()).get(ScoreCardViewModel.class);

        viewModel.getScoreCard().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                txtScore.setText(String.valueOf(integer));
            }
        });

        return view;
    }

    @OnClick(R.id.tv_score)
    public void onViewTapped() {
        // increment the score on fragment tap
        viewModel.incrementScore();
    }
}
