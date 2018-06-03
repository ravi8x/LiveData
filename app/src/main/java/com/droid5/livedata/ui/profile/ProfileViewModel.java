package com.droid5.livedata.ui.profile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.droid5.livedata.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<User> user;

    public LiveData<User> getUser() {
        if (user == null) {
            prepareUser();
        }
        return user;
    }

    private void prepareUser() {
        User u = new User();
        u.setName("Ravi Tamada");
        u.setEmail("ravi@androidhive.info");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("99939494949");
        phoneNumbers.add("93223949322");
        phoneNumbers.add("WhatsApp");
        phoneNumbers.add("Send Message");
        u.setPhoneNumbers(phoneNumbers);

        u.setLocation("India");
        u.setProfileImageUrl("https://avatars3.githubusercontent.com/u/497670?s=460&v=4");
        u.setProfileCoverImage("http://hdqwalls.com/wallpapers/material-design-dark-red-black-ap.jpg");

        user = new MutableLiveData<>();
        user.setValue(u);
    }
}
