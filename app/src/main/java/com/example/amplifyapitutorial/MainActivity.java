package com.example.amplifyapitutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.core.Amplify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestOptions options = RestOptions.builder()
                .addPath("/todo")
                .addBody("{\"name\":\"Mow the lawn\"}".getBytes())
                .build();

        Amplify.API.post(options,
                response -> Log.i("MyAmplifyApp", "POST " + response.getData().asString()),
                error -> Log.e("MyAmplifyApp", "POST failed", error)
        );
    }
}
