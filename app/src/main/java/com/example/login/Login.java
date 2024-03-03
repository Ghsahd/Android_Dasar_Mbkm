package com.example.login;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        // Inisialisasi elemen-elemen UI
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);

        // Memberikan aksi klik pada tombol login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(email.isEmpty() || email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Email harus diisi", Toast.LENGTH_SHORT).show();
                } else if(password.isEmpty() || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Password harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    // Panggil metode login
                    loginUser(email, password);
                }

            }
        });
    }

    private void loginUser(String email, String password) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedEmail = sharedPreferences.getString(Preferences.KEY_EMAIL, "");
        String savedPassword = sharedPreferences.getString(Preferences.KEY_PASSWORD, "");

        if (email.equals(savedEmail) && password.equals(savedPassword)) {
            progressDialog.dismiss();
            saveLoginSession(email, password);
            showMainPage();
        } else {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Login gagal. Silakan coba lagi.", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLoginSession(String email, String password) {
        Preferences.saveLoginSession(Login.this, email, password);
    }

    private void showMainPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openRegisterActivity(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }


}