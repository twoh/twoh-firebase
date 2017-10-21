package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.web.twoh.twohfirebase.model.Barang;

/**
 * Created by Herdi_WORK on 08.08.17.
 */

public class FirebaseDBCreateActivity extends AppCompatActivity {

    private DatabaseReference database;
    private Button btSubmit;
    private EditText etNama;
    private EditText etMerk;
    private EditText etHarga;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);
        etNama = (EditText) findViewById(R.id.et_namabarang);
        etMerk = (EditText) findViewById(R.id.et_merkbarang);
        etHarga = (EditText) findViewById(R.id.et_hargabarang);
        btSubmit = (Button) findViewById(R.id.bt_submit);
        database = FirebaseDatabase.getInstance().getReference();

        final Barang barang = (Barang) getIntent().getSerializableExtra("data");
        if(barang!=null){
            etNama.setText(barang.getNama());
            etMerk.setText(barang.getMerk());
            etHarga.setText(barang.getHarga());
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    barang.setNama(etNama.getText().toString());
                    barang.setMerk(etMerk.getText().toString());
                    barang.setHarga(etHarga.getText().toString());

                    updateBarang(barang);
                }
            });
        }
        else{
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    submitBarang(new Barang(etNama.getText().toString(),etMerk.getText().toString(),etHarga.getText().toString()));
                }
            });
        }
    }

    private void updateBarang(Barang barang) {
        database.child("barang").child(barang.getKey()).setValue(barang).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                finish();
            }
        });
    }

    private void submitBarang(Barang barang){
        database.child("barang").push().setValue(barang);
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBCreateActivity.class);
    }
}
