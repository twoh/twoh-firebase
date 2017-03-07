package id.web.twoh.twohfirebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Herdi_WORK on 07.03.17.
 */

public class FirebaseAnalyticsActivity extends AppCompatActivity {

    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "789876");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "TWOH Firebase");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "tutorial");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
