package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import id.web.twoh.twohfirebase.adapter.AdapterBarangRecyclerView;
import id.web.twoh.twohfirebase.model.Barang;

/**
 * Created by Herdi_WORK on 18.06.17.
 */

public class FirebaseDBReadActivity extends AppCompatActivity {

    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_read);
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);


        database = FirebaseDatabase.getInstance().getReference();
        database.child("barang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Barang> daftarBarang = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Barang barang = noteDataSnapshot.getValue(Barang.class);
                    daftarBarang.add(barang);
                    System.out.println("BARANG "+barang.getNama()+" "+barang.getMerk()+" "+barang.getHarga());
                }
                System.out.println("BARANG DATA LOADED "+daftarBarang.size());
                adapter = new AdapterBarangRecyclerView(daftarBarang);
                rvView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadActivity.class);
    }
}
