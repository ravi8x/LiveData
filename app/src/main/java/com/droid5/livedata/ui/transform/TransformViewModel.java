package com.droid5.livedata.ui.transform;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.droid5.livedata.model.User;


/**
 * The examples provided here not best practises.
 * They are more of syntactical representation
 */
public class TransformViewModel extends ViewModel {
    private MutableLiveData<User> user;

    // full address is not member of user
    // it will be prepared dynamically using Transformation
    private LiveData<String> fullAddress;

    public LiveData<User> getUser() {
        if (user == null) {
            prepareUser();
        }
        return user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }


    /**
     * Preparing full address using map operator transformation
     */
    public LiveData<String> getFullAddress() {
        if (user == null)
            return null;

        fullAddress = Transformations.map(user, new Function<User, String>() {
            @Override
            public String apply(User user) {
                StringBuilder address = new StringBuilder(user.getStreetAddress());
                address.append("\n");
                address.append(user.getCity() + ", " + user.getCountry() + " - " + user.getPinCode());
                address.append("\n");
                address.append("Ph: +91" + user.getPrimaryMobile() + ", ");
                address.append("+91" + user.getSecondaryMobile());

                return address.toString();
            }
        });

        return fullAddress;
    }

    /**
     * Preparing dummy user. This should be done using a
     * repository
     */
    private void prepareUser() {
        User u = new User();
        u.setName("Ravi Tamada");
        u.setEmail("ravi@androidhive.info");

        u.setCountry("India");
        u.setStreetAddress("Flat 404, Olympia Building, Powai");
        u.setCity("Mumbai");
        u.setPinCode("400076");

        u.setPrimaryMobile("9839939393");
        u.setSecondaryMobile("8193000030");

        user = new MutableLiveData<>();
        user.setValue(u);
    }
}
