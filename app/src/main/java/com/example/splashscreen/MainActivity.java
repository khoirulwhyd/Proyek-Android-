package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nik, nama, alamat, keluhan;
    private String id;
    //Databsase
    private DatabaseReference AntrianOnline;

    private ListView_daftar LD;
    private List<klik_daftar> lisdaf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nik = findViewById(R.id.editText);
        nama = findViewById(R.id.editText2);
        alamat = findViewById(R.id.editText3);
        keluhan = findViewById(R.id.editText4);

        AntrianOnline = FirebaseDatabase.getInstance().getReference("klik_daftar");

        LD = findViewById(R.id.ListView_Daftar);
        lisdaf = new ArrayList<>();

        LD.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id){
               klik_daftar kd = lisdaf.get(position);
               String idDaftar = kd.getId();
               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               intent.putExtra(intent);
           }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        AntrianOnline.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()){
                    klik_daftar kd = postSnapshot.getValue(klik_daftar.class);
                    ListView_daftar.add(kd);
                }

                ListView_daftar Listview_daftar_adapter = new ListView_daftar(MainActivity.this, ListView_daftar);
                LD.setAdapter(Listview_daftar_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addDaftar (View view){
        String daftar_nik = nik.getText().toString();
        String daftar_nama = nama.getText().toString();
        String daftar_alamat = alamat.getText().toString();
        String daftar_keluhan = keluhan.getText().toString();

        if (!TextUtils.isEmpty(nik) && !TextUtils.isEmpty(nama) && !TextUtils.isEmpty(alamat) && !TextUtils.isEmpty(keluhan)){
            String id = AntrianOnline.push().getKey();

            klik_daftar kd = new klik_daftar(id, nik, nama, alamat, keluhan);
            AntrianOnline.child(id).setValue(kd).addOnSuccessListener(this, new onSuccesListner<void>(){
                @Override
                public void onSucces(Void aVoid){
                    nik.setText("");
                    nama.setText("");
                    alamat.setText("");
                    keluhan.setText("");
                    Toast.makeText(MainActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_LONG.show());
                }
            });
        }
        else {
            Toast.makeText(this,"Semua kolom harus diisi", Toast.LENGTH_LONG).show();
        }
    }

    public void daftar(View view) {
        Intent intent = new Intent(MainActivity.this, klik_daftar.class);
        startActivity(intent);
    }

    public void lihatantrean(View view) {
        Intent intent = new Intent(MainActivity.this, klik_lihatantrean.class);
        startActivity(intent);
    }

    public void riwayat(View view) {
        Intent intent = new Intent(MainActivity.this, klik_riwayat.class);
        startActivity(intent);
    }
}