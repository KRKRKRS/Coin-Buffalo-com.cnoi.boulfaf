package com.cnoi.boulfaf;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menuboulfafctivity extends AppCompatActivity {
    private WebView webVpshhaoraiew;
    private Button gpshhaoram;
    private Button plpshhaorac;
    private Button expshhaorat;

    @Override
    protected void onCreate(Bundle savedInstboulfafanceState) {
        getWindow().addFlags(1024);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstboulfafanceState);
        setContentView(R.layout.activity_mboulfafenu);
        webVpshhaoraiew = findViewById(R.id.policyWeb);
        gpshhaoram = findViewById(R.id.StartGame);
        plpshhaorac = findViewById(R.id.privacyBtn);
        expshhaorat = findViewById(R.id.exitBtn);
    }

    @Override
    public void onBackPressed() {
        webVpshhaoraiew.setVisibility(View.INVISIBLE);
        gpshhaoram.setVisibility(View.VISIBLE);
        plpshhaorac.setVisibility(View.VISIBLE);
        expshhaorat.setVisibility(View.VISIBLE);
    }

    public void startGpshhaorame(View view) {
        startActivity(new Intent(this, Mboulfafity.class));
        finish();
    }

    public void goprivpshhaoris(View view) {
        webVpshhaoraiew.setVisibility(View.VISIBLE);
        gpshhaoram.setVisibility(View.INVISIBLE);
        plpshhaorac.setVisibility(View.INVISIBLE);
        expshhaorat.setVisibility(View.INVISIBLE);
        webVpshhaoraiew.loadUrl("https://www.privacypolicyonline.com/live.php?token=tsgyyABSo0Ktl58gSvP5dDSlW4TodTP8");
    }

    public void exitoris(View view) {
        finish();
    }
}