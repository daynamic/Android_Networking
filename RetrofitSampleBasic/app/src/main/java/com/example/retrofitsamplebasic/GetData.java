package com.example.retrofitsamplebasic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aks on 23/01/2019.
 */
public interface GetData {
    @GET("5c481426310000bb408a1fcc")
    Call <RetroData> getAllUsers();

}
