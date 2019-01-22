package com.example.atzz.volleyimagerequest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button cl;
    ImageView iV;
    // URL of image to be parsed
    String img_url = "https://ak2.picdn.net/shutterstock/videos/15181582/thumb/1.jpg";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        //intializing the button
        cl=(Button)findViewById(R.id.button1);
        iV=(ImageView)findViewById(R.id.imageView);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest=new ImageRequest(img_url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iV.setImageBitmap(response);
                    }
                },0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        iV.setImageResource(R.drawable.ic_launcher_foreground);
                    }
                });
                requestQueue.add(imageRequest);
            }
    });

}
}
