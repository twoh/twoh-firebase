package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FirebaseAdMobBannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob_banner);

        MobileAds.initialize(this, "ca-app-pub-6916955256570875~9544586213");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId("ca-app-pub-6916955256570875/4699453642");
        adView.setAdListener(new AdListener(){

            @Override
            public void onAdFailedToLoad(int i) {
                Log.i("Ads error","Error Ads not loaded error code " + i);
            }

            @Override
            public void onAdLoaded() {
                Log.i("Ads error","ads loaded");
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FirebaseAdMobBannerActivity.class);
    }
}
