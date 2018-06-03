package com.droid5.livedata.ui.scorecard;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ScoreCardViewModel extends ViewModel {
    private MutableLiveData<Integer> scoreCard = new MutableLiveData<>();

    public MutableLiveData<Integer> getScoreCard() {
        if (scoreCard.getValue() == null) {
            // set initial score to 0
            scoreCard.setValue(0);
        }
        return scoreCard;
    }

    public Integer getScore() {
        return scoreCard.getValue();
    }

    public void incrementScore() {
        this.scoreCard.setValue(scoreCard.getValue() + 1);
    }
}
