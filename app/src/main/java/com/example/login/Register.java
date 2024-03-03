package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText editTextNama, editTextEmail, editTextUsername, editTextPassword, editTextConfirmPassword;
    private Button buttonRegistrasi;
    private TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        // Inisialisasi tampilan
        editTextNama = findViewById(R.id.editTextUserName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonRegistrasi = findViewById(R.id.buttonRegister);
        textViewLogin = findViewById(R.id.textViewLogin);

        buttonRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan data dari input pengguna
                String nama = editTextNama.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmPassword = editTextConfirmPassword.getText().toString().trim();

                // Memeriksa apakah semua field telah diisi
                if (email.isEmpty() || password.isEmpty() || nama.isEmpty() || username.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(Register.this, "Harap isi semua field", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    // Password dan Konfirmasi Password tidak cocok
                    Toast.makeText(Register.this, "Password dan Konfirmasi Password harus sama", Toast.LENGTH_SHORT).show();
                } else {
                    Preferences.saveDataRegister(Register.this, nama, email, username, password);
                    Preferences.saveLoginSession(Register.this, email, password);
                    Toast.makeText(Register.this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                    backToLogin();
                }
            }
        });


        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });
    }

    // Metode untuk kembali ke halaman login
    private void backToLogin() {
        finish();
    }


}