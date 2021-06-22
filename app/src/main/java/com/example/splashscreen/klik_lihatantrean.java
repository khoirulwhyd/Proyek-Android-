package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class klik_lihatantrean extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klik_lihatantrean);
    }

    public void kembali(View view) {
        Intent intent = new Intent(klik_lihatantrean.this, MainActivity.class);
        startActivity(intent);
    }
}