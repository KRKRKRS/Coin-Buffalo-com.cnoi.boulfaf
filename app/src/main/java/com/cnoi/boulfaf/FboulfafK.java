package com.cnoi.boulfaf;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class FboulfafK {
    public static String stboboulfafafrDeep;
    public static String AD_boulfafD;
    private String fbboulfafId;
    private C9B mainActboulfafivity;

    public FboulfafK(String fbboulfafId, C9B mainAboulfafctivity) {
        this.fbboulfafId = fbboulfafId;
        this.mainActboulfafivity = mainAboulfafctivity;
    }

    public void iniboulfaft() {
        FacebookSdk.setApplicationId(fbboulfafId);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(mainActboulfafivity.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        AppEventsLogger.activateApp(mainActboulfafivity.getApplication());

        new Thread(new Runnable() {
            public void run() {
                try {
                    AD_boulfafD = AdvertisingIdClient.getAdvertisingIdInfo(mainActboulfafivity.getBaseContext()).getId();
                } catch (IOException e) {
                } catch (GooglePlayServicesNotAvailableException e) {
                } catch (GooglePlayServicesRepairableException e) {
                }
            }
        }).start();

        AppLinkData.fetchDeferredAppLinkData(mainActboulfafivity.getApplication(), appLinkData -> {
                    stboboulfafafrDeep = appLinkData.getTargetUri().getQuery();
                }
        );
    }

    public void setWboulfafebView(WebView webViewetgpy) {
        webViewetgpy.getSettings().setJavaScriptEnabled(true);
        webViewetgpy.getSettings().setAppCacheEnabled(true);
        webViewetgpy.getSettings().setDomStorageEnabled(true);
        webViewetgpy.getSettings().setAllowContentAccess(true);
        webViewetgpy.getSettings().setAllowFileAccess(true);
        webViewetgpy.getSettings().setAppCacheEnabled(true);
        webViewetgpy.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewetgpy.getSettings().setSaveFormData(true);
        webViewetgpy.getSettings().setMixedContentMode(0);
        webViewetgpy.getSettings().setSavePassword(true);
        webViewetgpy.getSettings().setAllowContentAccess(true);
        webViewetgpy.getSettings().setLoadsImagesAutomatically(true);
        webViewetgpy.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewetgpy.getSettings().setDatabaseEnabled(true);
        webViewetgpy.getSettings().setLoadWithOverviewMode(true);
        webViewetgpy.getSettings().setUseWideViewPort(true);
        webViewetgpy.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewetgpy.getSettings().setDomStorageEnabled(true);
        webViewetgpy.getSettings().setAllowFileAccess(true);
        webViewetgpy.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewetgpy.getSettings().setEnableSmoothTransition(true);
    }
}
