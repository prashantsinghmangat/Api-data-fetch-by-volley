package com.demotxt.myapp.myapplication.Dashboardbmr.model;

/**
 * Created by Aws on 11/03/2018.
 */

public class Anime {

    private String givenName ;
    private String middleName;
    private String email;
    private int dateOfBirth;
    private String phoneNumber;
    private String personId ;
    private String image_url;

    public Anime() {
    }

    public Anime(String givenName, String middleName, String email, int dateOfBirth, String phoneNumber, String personId, String image_url) {
        this.givenName = givenName;
        this.middleName = middleName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
        this.image_url = image_url;
    }


    public String getGivenName() {
        return givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonId() {
        return personId;
    }

    public String getImage_url() {
        return image_url;
    }


    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
