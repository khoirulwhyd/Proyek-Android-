package com.example.splashscreen;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    private EditText nik, nama, alamat, keluhan;
    private String id;
    //Databsase
    private DatabaseReference AntrianOnline;

    @Override
    protected void onCreate(Bundle savedInstsnceState){
        super.onCreate(savedInstsnceState);
        setContentView(R.layout.activity_main);
        id = getIntent().getStringExtra("Id");
        nik = findViewById(R.id.editText);
        nama = findViewById(R.id.editText2);
        alamat = findViewById(R.id.editText3);
        keluhan = findViewById(R.id.editText4);

        AntrianOnline = FirebaseDatabase.getInstance().getReference("ANTRIANONLINE").child(biodataId);
    }

    @Override
    protected void onStart(){
        super.onStart();
        AntrianOnline.addValueEventListener(new ValueEventListener()){
            @Override
            public void onDataChange(DataSnapshot snapshot){
                klik_daftar kd = snapshot.getValue(klik_daftar.class);
                if (kd != null){
                    String nikS = kd.getNik();
                    String namaS = kd.getNamaLengkap();
                    String alamatS = kd.getAlamat();
                    String keluhanS = kd.getKeluhan();
                    nik.setText(nikS);
                    nama.setText(namaS);
                    alamat.setText(alamatS);
                    keluhan.setText(keluhanS);
                }
            }
        }
    }
}
