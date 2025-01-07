package com.example.aplikasikoperasi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplikasikoperasi.R;

public class DashboardActivity extends AppCompatActivity {
    private Button btnSimpanan, btnPinjaman, btnAnggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inisialisasi elemen layout
        btnSimpanan = findViewById(R.id.btnSimpanan);
        btnPinjaman = findViewById(R.id.btnPinjaman);
        btnAnggota = findViewById(R.id.btnAnggota);

        // Navigasi ke fitur anggota
        btnAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AnggotaActivity.class);
                startActivity(intent);
            }
        });

        // Navigasi ke fitur pinjaman
        btnPinjaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PinjamanActivity.class);
                startActivity(intent);
            }
        });

        // Navigasi ke fitur simpanan
        btnSimpanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SimpananActivity.class);
                startActivity(intent);
            }
        });
    }
}