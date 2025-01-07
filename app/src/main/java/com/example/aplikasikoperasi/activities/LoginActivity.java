package com.example.aplikasikoperasi.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasikoperasi.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        // Cek apakah user sudah login
        if (isLoggedIn()) {
            // Jika sudah login, langsung buka Dashboard
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                // Cek login di sini, misalnya dengan memeriksa username dan password
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    // Menampilkan pesan jika field kosong
                    Toast.makeText(LoginActivity.this, "Username dan Password harus diisi", Toast.LENGTH_SHORT).show();
                } else if (username.equals("admin") && password.equals("password")) {
                    // Login berhasil, menyimpan status login
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("is_logged_in", true);
                    editor.apply();

                    // Pindah ke DashboardActivity
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Menampilkan pesan error jika login gagal
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Fungsi untuk mengecek apakah pengguna sudah login
    private boolean isLoggedIn() {
        return sharedPreferences.getBoolean("is_logged_in", false);
    }
}
