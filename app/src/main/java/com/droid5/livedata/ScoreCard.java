package com.droid5.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class ScoreCard {
    private MutableLiveData<Integer> score;

    public ScoreCard() {
        score = new MutableLiveData<>();
        score.setValue(0);
    }

    public LiveData<Integer> getScore() {
        return score;
    }

    public void incrementScore() {
        // increment the score by 1
        score.setValue(score.getValue() + 1);
    }
}
