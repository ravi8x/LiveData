package com.droid5.livedata.model;

import java.util.List;

public class User {
    String name;
    String email;
    String profileImageUrl;
    String profileCoverImage;
    List<String> callActions;
    String city;
    String country;
    String streetAddress;
    String pinCode;
    String primaryMobile;
    String secondaryMobile;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileCoverImage() {
        return profileCoverImage;
    }

    public void setProfileCoverImage(String profileCoverImage) {
        this.profileCoverImage = profileCoverImage;
    }

    public List<String> getCallActions() {
        return callActions;
    }

    public void setCallActions(List<String> callActions) {
        this.callActions = callActions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPrimaryMobile() {
        return primaryMobile;
    }

    public void setPrimaryMobile(String primaryMobile) {
        this.primaryMobile = primaryMobile;
    }

    public String getSecondaryMobile() {
        return secondaryMobile;
    }

    public void setSecondaryMobile(String secondaryMobile) {
        this.secondaryMobile = secondaryMobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
