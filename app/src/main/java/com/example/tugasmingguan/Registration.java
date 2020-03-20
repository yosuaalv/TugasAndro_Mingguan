package com.example.tugasmingguan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    DBHelper db;
    EditText newEmail;
    EditText newPasswd;
    EditText confPasswd;
    Button btnReg;
    TextView txtReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);
        db = new DBHelper(this);
        newEmail = (EditText) findViewById(R.id.emailReg);
        newPasswd = (EditText) findViewById(R.id.passReg);
        confPasswd = (EditText) findViewById(R.id.confPassReg);
        btnReg = (Button) findViewById(R.id.buttonReg);
        txtReg = (TextView) findViewById(R.id.backLogin);
        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginInt = new Intent(Registration.this, MainActivity.class);
                startActivity(loginInt);
            }
        });



        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = newEmail.getText().toString().trim();
                String password = newPasswd.getText().toString().trim();
                String confPassword = confPasswd.getText().toString().trim();

                if (password.equals(confPassword)) {
                    long val = db.addUsers(mail,password);
                    if (val > 0) {
                        Toast.makeText(Registration.this, "Registrai Berhasil!", Toast.LENGTH_SHORT).show();
                        Intent newLogin = new Intent(Registration.this, MainActivity.class);
                        startActivity(newLogin);
                    } else {
                        Toast.makeText(Registration.this, "Registrasi Error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registration.this, "Password Tidak Sama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
