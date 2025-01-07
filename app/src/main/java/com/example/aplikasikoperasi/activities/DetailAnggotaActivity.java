package com.example.aplikasikoperasi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplikasikoperasi.R;
import com.example.aplikasikoperasi.models.Anggota;
import com.example.aplikasikoperasi.helpers.DatabaseHelper;
public class DetailAnggotaActivity extends AppCompatActivity {

    private TextView textViewNama;
    private TextView textViewNik;
    private TextView textViewTglLahir;
    private TextView textViewNoRek;
    private TextView textViewNamaBank;
    private TextView textViewTmptLahir;
    private TextView textViewNoHP;
    private TextView textViewAlamat;
    private TextView textViewJK;
    private Button buttonEdit;
    private Button buttonDelete;
    private Anggota anggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anggota);

        // Inisialisasi TextView dan Button
        textViewNama = findViewById(R.id.textViewNama);
        textViewNik = findViewById(R.id.textViewNik);
        textViewTglLahir = findViewById(R.id.textViewTglLahir);
        textViewNoRek = findViewById(R.id.textViewNoRek);
        textViewNamaBank = findViewById(R.id.textViewNamaBank);
        textViewTmptLahir = findViewById(R.id.textViewTmptLahir);
        textViewNoHP = findViewById(R.id.textViewNoHP);
        textViewAlamat = findViewById(R.id.textViewAlamat);
        textViewJK = findViewById(R.id.textViewJK);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonDelete = findViewById(R.id.buttonDelete);

        // Ambil data anggota dari intent
        Intent intent = getIntent();
        anggota = (Anggota) intent.getSerializableExtra("anggota");

        // Tampilkan detail anggota
        displayDetails(anggota);

        // Set up onClickListener untuk tombol edit
        buttonEdit.setOnClickListener(v -> {
            Intent editIntent = new Intent(DetailAnggotaActivity.this, EditAnggotaActivity.class);
            editIntent.putExtra("anggota", anggota);
            startActivity(editIntent);
        });

        // Set up onClickListener untuk tombol hapus
        buttonDelete.setOnClickListener(v -> {
            // Tambahkan logika untuk menghapus anggota, misal memanggil metode delete
            deleteAnggota(anggota.getId());
        });
    }

    private void displayDetails(Anggota anggota) {
        textViewNama.setText(anggota.getNama());
        textViewNik.setText(anggota.getNik());
        textViewTglLahir.setText(anggota.getTtl());
        textViewNoRek.setText(anggota.getNoRek());
        textViewNamaBank.setText(anggota.getNamaBank());
        textViewTmptLahir.setText(anggota.getTmptLahir());
        textViewNoHP.setText(anggota.getNoHP());
        textViewAlamat.setText(anggota.getAlamat());
        textViewJK.setText(anggota.getJenisKelamin());
    }

    private void deleteAnggota(int id) {
        // Tambahkan logika untuk menghapus anggota dari database
        // Misalnya, panggil metode delete di DatabaseHelper
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.deleteAnggota(id);
        finish(); // Kembali ke daftar anggota setelah dihapus
    }
}