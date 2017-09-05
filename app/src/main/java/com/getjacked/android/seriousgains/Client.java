package com.getjacked.android.seriousgains;

import java.util.UUID;

/**
 * Client Object Defined Below
 */

public class Client {

    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mPronouns;
    private int mWeight;
    private String mHeight;
    private String mStreetAddress;
    private String mCity;
    private String mState;
    private int mZipCode;
    private String mCreditCardNumber;
    private String mCreditCardType;
    private int mCVC;

    public Client(){
        // generate unique identifier
        mId = UUID.randomUUID();
    }


    public UUID getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getPronouns() {
        return mPronouns;
    }

    public void setPronouns(String pronouns) {
        mPronouns = pronouns;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getStreetAddress() {
        return mStreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        mStreetAddress = streetAddress;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public int getZipCode() {
        return mZipCode;
    }

    public void setZipCode(int zipCode) {
        mZipCode = zipCode;
    }

    public String getCreditCardNumber() {
        return mCreditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        mCreditCardNumber = creditCardNumber;
    }

    public String getCreditCardType() {
        return mCreditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        mCreditCardType = creditCardType;
    }

    public int getCVC() {
        return mCVC;
    }

    public void setCVC(int CVC) {
        mCVC = CVC;
    }
}
