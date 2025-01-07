package com.example.aplikasikoperasi.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplikasikoperasi.R;
import com.example.aplikasikoperasi.adapters.AnggotaAdapter;
import com.example.aplikasikoperasi.helpers.DatabaseHelper;
import com.example.aplikasikoperasi.models.Anggota;
import java.util.List;

public class ListAnggotaActivity extends AppCompatActivity {

    private ListView listViewAnggota;
    private AnggotaAdapter anggotaAdapter;
    private List<Anggota> anggotaList;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_anggota);

        listViewAnggota = findViewById(R.id.listViewAnggota);
        Button buttonKembali = findViewById(R.id.buttonKembali);
        Button buttonEdit = findViewById(R.id.buttonEdit);
        Button buttonHapus = findViewById(R.id.buttonHapus);
        dbHelper = new DatabaseHelper(this);

        loadAnggota();

        // Navigasi kembali ke Dashboard
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke activity sebelumnya
            }
        });

        // Logika untuk Edit dan Hapus akan ditambahkan di sini
        // Misalnya:
        // buttonEdit.setOnClickListener(...);
        // buttonHapus.setOnClickListener(...);
    }

    private void loadAnggota() {
        anggotaList = dbHelper.getAllAnggota();
        anggotaAdapter = new AnggotaAdapter(this, anggotaList);
        listViewAnggota.setAdapter(anggotaAdapter);
    }
}