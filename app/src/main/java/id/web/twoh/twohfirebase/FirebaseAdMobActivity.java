package id.web.twoh.twohfirebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirebaseAdMobActivity extends AppCompatActivity{

    Button btBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBanner = findViewById(R.id.bt_adbanner);
        btBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAdMobBannerActivity.getActIntent(FirebaseAdMobActivity.this);
            }
        });

    }
}
