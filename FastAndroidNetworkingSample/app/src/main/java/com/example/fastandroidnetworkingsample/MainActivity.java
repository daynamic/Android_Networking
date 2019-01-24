package com.example.fastandroidnetworkingsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    final String server_url = "http://www.mocky.io/v2/5c455b46320000ca10af16ae";
    private TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV=(TextView)findViewById(R.id.TextView);

        /**
         * Initializing Fast Android Networking Library in Activity or Fragments
         * */
        AndroidNetworking.initialize(getApplicationContext());

        init();

    }

    private void init(){
        AndroidNetworking.get(server_url)
                .setTag("Test")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tV.setText(response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, "Unable to connect", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
