package com.example.aplikasikoperasi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aplikasikoperasi.R;
import com.example.aplikasikoperasi.models.Anggota;

import java.util.List;

public class AnggotaAdapter extends ArrayAdapter<Anggota> {

    private Context context;
    private List<Anggota> anggotaList;

    public AnggotaAdapter(Context context, List<Anggota> anggotaList) {
        super(context, 0, anggotaList);
        this.context = context;
        this.anggotaList = anggotaList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_anggota, parent, false);
        }

        Anggota currentAnggota = anggotaList.get(position);
        TextView textViewNama = convertView.findViewById(R.id.textViewNama);
        TextView textViewNik = convertView.findViewById(R.id.textViewNik);

        textViewNama.setText(currentAnggota.getNama());
        textViewNik.setText(currentAnggota.getNik());

        return convertView;
    }
}