package com.example.frendzapp;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIRequests {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static void submitRegister(String url, OkHttpClient client, String json) {

        RequestBody body = RequestBody.create(json, JSON);
        Request req = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    //TODO redirect to a Login Activity
                }
            }
        });
    }
}
