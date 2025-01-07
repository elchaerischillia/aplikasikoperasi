package com.example.aplikasikoperasi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplikasikoperasi.R;
import com.example.aplikasikoperasi.helpers.DatabaseHelper;
import android.widget.ArrayAdapter;
public class AnggotaActivity extends AppCompatActivity {

    private EditText editTextNamaLengkap, editTextNik, editTextTglLahir, editTextNoRek, editTextNamaBank, editTextTmptLahir, editTextNoHP, editTextAlamat;
    private Button buttonSimpanAnggota;
    private DatabaseHelper dbHelper;
    private Spinner spinnerJK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);

        // Menghubungkan variabel dengan tampilan
        editTextNamaLengkap = findViewById(R.id.editTextNamaLengkap);
        editTextNik = findViewById(R.id.editTextNik);
        editTextTglLahir = findViewById(R.id.editTextTglLahir);
        editTextNoRek = findViewById(R.id.editTextNoRek);
        editTextNamaBank = findViewById(R.id.editTextNamaBank);
        editTextTmptLahir = findViewById(R.id.editTextTmptLahir);
        editTextNoHP = findViewById(R.id.editTextNoHP);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        buttonSimpanAnggota = findViewById(R.id.buttonSimpanAnggota);
        spinnerJK = findViewById(R.id.spinnerJK);

        dbHelper = new DatabaseHelper(this);

        // Inisialisasi Spinner dengan array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jenis_kelamin_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJK.setAdapter(adapter);

        buttonSimpanAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNamaLengkap.getText().toString().trim();
                String nik = editTextNik.getText().toString().trim();
                String ttl = editTextTglLahir.getText().toString().trim();
                String noRek = editTextNoRek.getText().toString().trim();
                String namaBank = editTextNamaBank.getText().toString().trim();
                String tmptLahir = editTextTmptLahir.getText().toString().trim();
                String noHP = editTextNoHP.getText().toString().trim();
                String alamat = editTextAlamat.getText().toString().trim();
                String jenisKelamin = spinnerJK.getSelectedItem().toString();

                if (validateInput(nama, nik, ttl, noRek, namaBank, tmptLahir, noHP, alamat)) {
                    long result = dbHelper.addAnggota(nama, nik, ttl, noRek, namaBank, tmptLahir, noHP, alamat, jenisKelamin);
                    if (result != -1) {
                        Toast.makeText(AnggotaActivity.this, "Anggota berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        clearFields();

                        // Navigasi ke ListAnggotaActivity
                        Intent intent = new Intent(AnggotaActivity.this, ListAnggotaActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AnggotaActivity.this, "Gagal menambahkan anggota", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validateInput(String nama, String nik, String ttl, String noRek, String namaBank, String tmptLahir, String noHP, String alamat) {
        if (nama.isEmpty() || nik.isEmpty() || ttl.isEmpty() || noRek.isEmpty() || namaBank.isEmpty() || tmptLahir.isEmpty() || noHP.isEmpty() || alamat.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (nik.length() != 16) {
            Toast.makeText(this, "NIK harus 16 digit", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void clearFields() {
        editTextNamaLengkap.setText("");
        editTextNik.setText("");
        editTextTglLahir.setText("");
        editTextNoRek.setText("");
        editTextNamaBank.setText("");
        editTextTmptLahir.setText("");
        editTextNoHP.setText("");
        editTextAlamat.setText("");
        spinnerJK.setSelection(0);
    }
}