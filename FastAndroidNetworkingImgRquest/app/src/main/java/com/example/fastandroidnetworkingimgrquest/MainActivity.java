package com.example.fastandroidnetworkingimgrquest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.BitmapRequestListener;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private Button shw_Btn;
    private ImageView image_View;
    // URL of image to be parsed
    String img_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTf_YGnPJF_2RKx1Tzu1znh9bPIpKc78Htxa4YQABoZRgcMpclYkA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * Initializing Fast Android Networking Library in Activity or Fragments
 * */
        AndroidNetworking.initialize(getApplicationContext());


        image_View=(ImageView)findViewById(R.id.imageView);
        shw_Btn=(Button)findViewById(R.id.button1);
        shw_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidNetworking.get(img_url)
                        .setTag("Test_image")
                        .build()
                        .getAsBitmap(new BitmapRequestListener() {
                            @Override
                            public void onResponse(Bitmap response) {
                                image_View.setImageBitmap(response);
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(MainActivity.this, "Unable to download the image", Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });




    }
}
