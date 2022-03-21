package com.example.frendzapp;

import static com.example.frendzapp.APIRequests.submitRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;
    private EditText username;
    private EditText email;
    private EditText password;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.textView);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> elements = new HashMap<>();
                elements.put("username", username.getText().toString());
                elements.put("email", email.getText().toString());
                elements.put("password", password.getText().toString());

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    String json = objectMapper.writeValueAsString(elements);
                    submitRegister("http://123qwe:4000/register", new OkHttpClient(), json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}