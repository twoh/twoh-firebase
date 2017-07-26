package id.web.twoh.twohfirebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Herdi_WORK on 07.05.17.
 */

public class FirebaseDBActivity extends AppCompatActivity {

    private DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        database = FirebaseDatabase.getInstance().getReference();
    }
}
