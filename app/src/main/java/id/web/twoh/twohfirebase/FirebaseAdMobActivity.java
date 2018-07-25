package id.web.twoh.twohfirebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirebaseAdMobActivity extends AppCompatActivity{

    Button btBanner;
    Button btInterstitial;
    Button btNative;
    Button btVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob);

        btBanner = findViewById(R.id.bt_adbanner);
        btBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FirebaseAdMobBannerActivity.getActIntent(FirebaseAdMobActivity.this));
            }
        });

        btInterstitial = findViewById(R.id.bt_adinterstitial);
        btInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FirebaseAdMobInterstitialActivity.getActIntent(FirebaseAdMobActivity.this));
            }
        });

        btNative = findViewById(R.id.bt_adnative);
        btNative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FirebaseAdMobNativeActivity.getActIntent(FirebaseAdMobActivity.this));
            }
        });

        btVideo = findViewById(R.id.bt_advideo);
        btVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FirebaseAdMobVideoActivity.getActIntent(FirebaseAdMobActivity.this));
            }
        });
    }
}
