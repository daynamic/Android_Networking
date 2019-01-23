package com.example.retrofitsample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aks on 23/01/2019.
 */
public interface GetData {
    //Specify the request type and pass the relative URL//
    @GET("/users")
    //Wrap the response in a Call object with the type of the expected result//
    Call<List<RetroUsers>> getAllUsers();
}
