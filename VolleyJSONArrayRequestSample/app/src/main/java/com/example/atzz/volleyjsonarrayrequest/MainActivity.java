package com.example.atzz.volleyjsonarrayrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Will show the string "data" that holds the results
    TextView results;
    // URL of object to be parsed
    String JsonURL = "http://www.mocky.io/v2/5c45963a3200003b22af17eb.json";
    // This string will hold the results
    String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        // Casts results into the TextView found within the main layout XML with id jsonData
        results = (TextView) findViewById(R.id.jsonData);

        /**
         * Creating the JsonArrayRequest class called arrayreq, passing the required parameters
         * JsonURL is the URL to be fetched from
         * */
        JsonArrayRequest arrayreq = new JsonArrayRequest(JsonURL,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject colorObj = response.getJSONObject(0);
                    JSONArray colorArry = colorObj.getJSONArray("AnimalArray");
                    for (int i = 0; i < colorArry.length(); i++) {
                        JSONObject jsonObject = colorArry.getJSONObject(i);
                        String name = jsonObject.getString("AnimalName");
                        String traits = jsonObject.getString("traits");
                        data += "\n \n Animal Number " + (i + 1) + "\nAnimal Name: " + name +
                                "\nAnimal trait : " + traits ;
                    }
                    // Adds the data string to the TextView "results"
                    results.setText(data);
                }
                catch (JSONException e) {
                    // If an error occurs, this prints the error to the log
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            // Handles errors that occur due to Volley
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", "Error");
            }
        }
        );
        // Adds the JSON array request "arrayreq" to the request queue
        requestQueue.add(arrayreq);

    }
}
