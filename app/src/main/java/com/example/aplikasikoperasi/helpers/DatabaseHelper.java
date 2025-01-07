package com.example.aplikasikoperasi.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.aplikasikoperasi.models.Anggota;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "koperasi.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ANGGOTA = "anggota";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_NIK = "nik";
    private static final String COLUMN_TTL = "ttl";
    private static final String COLUMN_NO_REK = "no_rek";
    private static final String COLUMN_NAMA_BANK = "nama_bank";
    private static final String COLUMN_TMPT_LAHIR = "tmpt_lahir";
    private static final String COLUMN_NO_HP = "no_hp";
    private static final String COLUMN_ALAMAT = "alamat";
    private static final String COLUMN_JENIS_KELAMIN = "jenis_kelamin";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_ANGGOTA = "CREATE TABLE " + TABLE_ANGGOTA + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAMA + " TEXT, "
                + COLUMN_NIK + " TEXT, "
                + COLUMN_TTL + " TEXT, "
                + COLUMN_NO_REK + " TEXT, "
                + COLUMN_NAMA_BANK + " TEXT, "
                + COLUMN_TMPT_LAHIR + " TEXT, "
                + COLUMN_NO_HP + " TEXT, "
                + COLUMN_ALAMAT + " TEXT, "
                + COLUMN_JENIS_KELAMIN + " TEXT)";
        db.execSQL(CREATE_TABLE_ANGGOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANGGOTA);
        onCreate(db);
    }

    public long deleteAnggota(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_ANGGOTA, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public long addAnggota(String nama, String nik, String ttl, String noRek, String namaBank, String tmptLahir, String noHP, String alamat, String jenisKelamin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, nama);
        values.put(COLUMN_NIK, nik);
        values.put(COLUMN_TTL, ttl);
        values.put(COLUMN_NO_REK, noRek);
        values.put(COLUMN_NAMA_BANK, namaBank);
        values.put(COLUMN_TMPT_LAHIR, tmptLahir);
        values.put(COLUMN_NO_HP, noHP);
        values.put(COLUMN_ALAMAT, alamat);
        values.put(COLUMN_JENIS_KELAMIN, jenisKelamin);

        return db.insert(TABLE_ANGGOTA, null, values);
    }

    public long updateAnggota(Anggota anggota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, anggota.getNama());
        values.put(COLUMN_NIK, anggota.getNik());
        values.put(COLUMN_TTL, anggota.getTtl());
        values.put(COLUMN_NO_REK, anggota.getNoRek());
        values.put(COLUMN_NAMA_BANK, anggota.getNamaBank());
        values.put(COLUMN_TMPT_LAHIR, anggota.getTmptLahir());
        values.put(COLUMN_NO_HP, anggota.getNoHP());
        values.put(COLUMN_ALAMAT, anggota.getAlamat());
        values.put(COLUMN_JENIS_KELAMIN, anggota.getJenisKelamin());

        return db.update(TABLE_ANGGOTA, values, COLUMN_ID + " = ?", new String[]{String.valueOf(anggota.getId())});
    }

    public List<Anggota> getAllAnggota() {
        List<Anggota> anggotaList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ANGGOTA, null, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int indexId = cursor.getColumnIndex(COLUMN_ID);
                    int indexNama = cursor.getColumnIndex(COLUMN_NAMA);
                    int indexNik = cursor.getColumnIndex(COLUMN_NIK);
                    int indexTtl = cursor.getColumnIndex(COLUMN_TTL);
                    int indexNoRek = cursor.getColumnIndex(COLUMN_NO_REK);
                    int indexNamaBank = cursor.getColumnIndex(COLUMN_NAMA_BANK);
                    int indexTmptLahir = cursor.getColumnIndex(COLUMN_TMPT_LAHIR);
                    int indexNoHP = cursor.getColumnIndex(COLUMN_NO_HP);
                    int indexAlamat = cursor.getColumnIndex(COLUMN_ALAMAT);
                    int indexJenisKelamin = cursor.getColumnIndex(COLUMN_JENIS_KELAMIN);

                    // Memeriksa apakah semua kolom ditemukan
                    if (indexId != -1 && indexNama != -1 && indexNik != -1 && indexTtl != -1 &&
                            indexNoRek != -1 && indexNamaBank != -1 && indexTmptLahir != -1 &&
                            indexNoHP != -1 && indexAlamat != -1 && indexJenisKelamin != -1) {

                        Anggota anggota = new Anggota(
                                cursor.getInt(indexId),
                                cursor.getString(indexNama),
                                cursor.getString(indexNik),
                                cursor.getString(indexTtl),
                                cursor.getString(indexNoRek),
                                cursor.getString(indexNamaBank),
                                cursor.getString(indexTmptLahir),
                                cursor.getString(indexNoHP),
                                cursor.getString(indexAlamat),
                                cursor.getString(indexJenisKelamin)
                        );
                        anggotaList.add(anggota);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return anggotaList;
    }
}