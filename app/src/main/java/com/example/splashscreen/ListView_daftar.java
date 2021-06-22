package com.example.splashscreen;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.until.list;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListView_daftar extends ArrayAdapter {
    private Activity context;
    list<klik_daftar> list_daftar;

    public ListView_daftar(Activity context, List<klik_daftar>, klik_daftarArray) {
        super(context, R.layout.activity_klik_daftar, klik_daftarArray);
        this.context = context;
        this.list_daftar = klik_daftarArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_klik_daftar, null, true);
        TextView textViewNIK = listViewItem.findViewById(R.id.editText);
        TextView textViewNama = listViewItem.findViewById(R.id.editText2);
        TextView textViewAlamat = listViewItem.findViewById(R.id.editText3);
        TextView textViewKeluhan = listViewItem.findViewById(R.id.editText4);
        klik_daftar kd = list_daftar.get(position);
        textViewNIK.setText(kd.getNik());
        textViewNama.setText(kd.getNamaLengkap());
        textViewAlamat.setText(kd.getAlamat());
        textViewKeluhan.setText(kd.getKeluhan());
        return listViewItem;
    }
}

