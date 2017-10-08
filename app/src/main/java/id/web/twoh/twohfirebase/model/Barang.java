package id.web.twoh.twohfirebase.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Herdi_WORK on 18.06.17.
 */

@IgnoreExtraProperties
public class Barang {

    private String nama;
    private String merk;
    private String harga;

    public Barang(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+merk +"\n" +
                " "+harga;
    }

    public Barang(String nm, String mrk, String hrg){
        nama = nm;
        merk = mrk;
        harga = hrg;
    }
}
