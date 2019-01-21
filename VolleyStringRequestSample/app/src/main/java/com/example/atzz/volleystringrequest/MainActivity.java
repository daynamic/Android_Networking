package com.example.atzz.volleystringrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    private String server_url = "http://www.mocky.io/v2/5c455b46320000ca10af16ae";
    Button send_Request;
    Cache cache;
    Network network;
    RequestQueue requestQueue;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_Request = (Button) findViewById(R.id.button2);


        /**
         * DiskBasedCache provides a one-file-per-response cache with an in-memory index
         * */
        //Instantiate the cache
        cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);

        /**
         * BasicNetwork is Volley's default network implementation.
         * A BasicNetwork must be initialized with the HTTP client your app is using to connect to the network.
         * Typically this is an HttpURLConnection.
         * */
        //Set up the network to use HttpURLConnection as the HTTP client.
        network = new BasicNetwork(new HurlStack());

        /**
         * The above two are requirement for RequestQueue to do its job.
         * */
        // Instantiate the RequestQueue with the cache and network. Start the queue.
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        send_Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Formulate the request and handle the response.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /**
                         * displaying the response on screen
                         * */
                        //System.out.println("the response is "+response);
                        Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();
                        requestQueue.stop();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Error :" + error.toString());
                    }
                });
                // Add the request to the RequestQueue.
                requestQueue.add(stringRequest);
            }
        });
    }

}