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

    public List<Anggota> getAllAnggota() {
        List<Anggota> anggotaList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ANGGOTA, null);

        if (cursor.moveToFirst()) {
            do {
                String nama = cursor.getString(cursor.getColumnIndex(COLUMN_NAMA));
                String nik = cursor.getString(cursor.getColumnIndex(COLUMN_NIK));
                String ttl = cursor.getString(cursor.getColumnIndex(COLUMN_TTL));
                String noRek = cursor.getString(cursor.getColumnIndex(COLUMN_NO_REK));
                String namaBank = cursor.getString(cursor.getColumnIndex(COLUMN_NAMA_BANK));
                String tmptLahir = cursor.getString(cursor.getColumnIndex(COLUMN_TMPT_LAHIR));
                String noHP = cursor.getString(cursor.getColumnIndex(COLUMN_NO_HP));
                String alamat = cursor.getString(cursor.getColumnIndex(COLUMN_ALAMAT));
                String jenisKelamin = cursor.getString(cursor.getColumnIndex(COLUMN_JENIS_KELAMIN));

                Anggota anggota = new Anggota(nama, nik, ttl, noRek, namaBank, tmptLahir, noHP, alamat, jenisKelamin);
                anggotaList.add(anggota);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return anggotaList;
    }
}