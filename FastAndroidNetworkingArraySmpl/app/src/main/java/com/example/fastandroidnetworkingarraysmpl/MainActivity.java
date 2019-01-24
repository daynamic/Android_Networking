package com.example.fastandroidnetworkingarraysmpl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    final String server_url = "http://www.mocky.io/v2/5c494dfe320000e52b0b575d";
    private TextView tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV=(TextView)findViewById(R.id.jsonData);
/**
 * Initializing Fast Android Networking Library in Activity or Fragments
 * */
        AndroidNetworking.initialize(getApplicationContext());
        init();
    }

    private void init(){
      // Making call for fetching JSON Array via Fast Android Networking Library

        AndroidNetworking.get(server_url)
                .setTag("Test_Array")
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        tV.setText(response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, "unable to connect", Toast.LENGTH_SHORT).show();
                    }
                });


    }

}

