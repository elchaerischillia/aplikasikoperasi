package com.example.aplikasikoperasi.models;

import java.io.Serializable;

public class Anggota implements Serializable {
    private String nama;
    private String nik;
    private String ttl;
    private String noRek;
    private String namaBank;
    private String tmptLahir;
    private String noHP;
    private String alamat;
    private String jenisKelamin;

    public Anggota(String nama, String nik, String ttl, String noRek, String namaBank,
                   String tmptLahir, String noHP, String alamat, String jenisKelamin) {
        this.nama = nama;
        this.nik = nik;
        this.ttl = ttl;
        this.noRek = noRek;
        this.namaBank = namaBank;
        this.tmptLahir = tmptLahir;
        this.noHP = noHP;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter methods
    public String getNama() { return nama; }
    public String getNik() { return nik; }
    public String getTtl() { return ttl; }
    public String getNoRek() { return noRek; }
    public String getNamaBank() { return namaBank; }
    public String getTmptLahir() { return tmptLahir; }
    public String getNoHP() { return noHP; }
    public String getAlamat() { return alamat; }
    public String getJenisKelamin() { return jenisKelamin; }
}