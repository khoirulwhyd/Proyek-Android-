package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class klik_daftar extends AppCompatActivity {
    private String id;
    private String nik;
    private String namaLengkap;
    private String alamat;
    private String keluhan;

    public klik_daftar(){

    }
    public klik_daftar(String id, String nik, String namaLengkap, String alamat, String keluhan){
        this.id = id;
        this.nik = nik;
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.keluhan = keluhan;
    }

    public String getId() {
        return id;
    }

    public String getNik() {
        return nik;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKeluhan() {
        return keluhan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klik_daftar);
    }
}
