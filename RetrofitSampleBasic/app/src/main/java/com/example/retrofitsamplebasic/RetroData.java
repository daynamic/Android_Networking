package com.example.retrofitsamplebasic;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aks on 23/01/2019.
 */
public class RetroData {

    @SerializedName("name")
    private String users;

    public RetroData(String users) {
        this.users = users;

    }

    //Retrieve the data using setter/getter methods//
    public String getUser() {
        return users;
    }

}
