package com.example.aplikasikoperasi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplikasikoperasi.R;
import com.example.aplikasikoperasi.helpers.DatabaseHelper;
import com.example.aplikasikoperasi.models.Anggota;

public class EditAnggotaActivity extends AppCompatActivity {

    private EditText editTextNama, editTextNik, editTextTglLahir, editTextNoRek, editTextNamaBank, editTextTmptLahir, editTextNoHP, editTextAlamat;
    private Button buttonSave;
    private DatabaseHelper dbHelper;
    private Anggota anggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_anggota);

        editTextNama = findViewById(R.id.editTextNama);
        editTextNik = findViewById(R.id.editTextNik);
        editTextTglLahir = findViewById(R.id.editTextTglLahir);
        editTextNoRek = findViewById(R.id.editTextNoRek);
        editTextNamaBank = findViewById(R.id.editTextNamaBank);
        editTextTmptLahir = findViewById(R.id.editTextTmptLahir);
        editTextNoHP = findViewById(R.id.editTextNoHP);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        buttonSave = findViewById(R.id.buttonSave);

        dbHelper = new DatabaseHelper(this);

        // Ambil data anggota dari intent
        Intent intent = getIntent();
        anggota = (Anggota) intent.getSerializableExtra("anggota");

        // Tampilkan data anggota di EditText
        populateFields(anggota);

        buttonSave.setOnClickListener(v -> saveChanges());
    }

    private void populateFields(Anggota anggota) {
        editTextNama.setText(anggota.getNama());
        editTextNik.setText(anggota.getNik());
        editTextTglLahir.setText(anggota.getTtl());
        editTextNoRek.setText(anggota.getNoRek());
        editTextNamaBank.setText(anggota.getNamaBank());
        editTextTmptLahir.setText(anggota.getTmptLahir());
        editTextNoHP.setText(anggota.getNoHP());
        editTextAlamat.setText(anggota.getAlamat());
    }

    private void saveChanges() {
        // Simpan perubahan yang dilakukan
        // Implementasikan logika untuk menyimpan ke database
        Toast.makeText(this, "Perubahan disimpan", Toast.LENGTH_SHORT).show();
        finish(); // Kembali ke DetailAnggotaActivity
    }
}