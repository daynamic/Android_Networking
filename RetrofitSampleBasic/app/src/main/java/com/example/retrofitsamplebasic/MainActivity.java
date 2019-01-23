package com.example.retrofitsamplebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
     TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.TextView);


        GetData service = Client.getRetrofitInstance().create(GetData.class);
        Call <RetroData> call= service.getAllUsers();
        call.enqueue(new Callback<RetroData>() {
            @Override
            public void onResponse(Call<RetroData> call, Response<RetroData> response) {
              loaddata(response.body());
            }

            @Override
            public void onFailure(Call<RetroData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to load", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loaddata(RetroData retroData){
      tv.setText("First sample of retrofit by "+ retroData.getUser());

    }
}
