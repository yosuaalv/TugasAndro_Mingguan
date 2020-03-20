package com.example.tugasmingguan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText passwd;
    Button button;
    TextView txtRegis;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        email = (EditText) findViewById(R.id.emailTxt);
        passwd = (EditText) findViewById(R.id.passTxt);
        button = (Button) findViewById(R.id.loginBtn);
        txtRegis = (TextView) findViewById(R.id.signUp);
        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis = new Intent(MainActivity.this, Registration.class);
                startActivity(regis);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cekEmail = email.getText().toString().trim();
                String cekPass = passwd.getText().toString().trim();
                Boolean check = db.cekUsers(cekEmail,cekPass);
                if (check == true) {
                    Toast.makeText(MainActivity.this, "Selamat Datang", Toast.LENGTH_SHORT).show();
                    Intent hmpg = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(hmpg);
                } else {
                    Toast.makeText(MainActivity.this, "Username belum terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
