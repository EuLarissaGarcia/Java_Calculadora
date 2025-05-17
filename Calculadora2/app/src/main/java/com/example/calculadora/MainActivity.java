package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText input_user;
    private EditText input_password;
    private Button button_login;
    private Button button_cancel;

    private String password = "admin";

    private String user = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        input_user = findViewById(R.id.input_user);

        input_password = findViewById(R.id.input_password);

        Button login = findViewById(R.id.button_login);
        Button cancel = findViewById(R.id.button_cancel);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_user = input_user.getText().toString();
                String string_password = input_password.getText().toString();
                if(user.equals(string_user) && password.equals(string_password)){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();



            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_password.setText("");
                input_user.setText("");

            }
        });

    }
}