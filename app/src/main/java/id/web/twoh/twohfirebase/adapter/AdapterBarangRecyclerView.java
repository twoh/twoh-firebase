package id.web.twoh.twohfirebase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.web.twoh.twohfirebase.R;
import id.web.twoh.twohfirebase.model.Barang;

/**
 * Created by Hafizh Herdi on 10/8/2017.
 */

public class AdapterBarangRecyclerView extends RecyclerView.Adapter<AdapterBarangRecyclerView.ViewHolder> {

    private ArrayList<Barang> daftarBarang;

    public AdapterBarangRecyclerView(ArrayList<Barang> barangs){
        daftarBarang = barangs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tvTitle;

        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_namabarang);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = ((Barang)daftarBarang.get(position)).getNama();
        System.out.println("BARANG DATA one by one "+position+daftarBarang.size());
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        return daftarBarang.size();
    }
}
