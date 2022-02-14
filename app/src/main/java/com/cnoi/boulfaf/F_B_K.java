package com.cnoi.boulfaf;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class F_B_K {
    public static String strDeep;
    public static String AD_ID;
    private String fbId;
    private C9B mainActivity;

    public F_B_K(String fbId, C9B mainActivity) {
        this.fbId = fbId;
        this.mainActivity = mainActivity;
    }

    public void init () {
        FacebookSdk.setApplicationId(fbId);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(mainActivity.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        AppEventsLogger.activateApp(mainActivity.getApplication());


        new Thread(new Runnable() {
            public void run() {
                try {
                    AD_ID = AdvertisingIdClient.getAdvertisingIdInfo(mainActivity.getBaseContext()).getId();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        AppLinkData.fetchDeferredAppLinkData(mainActivity.getApplication(), appLinkData -> {
                strDeep = appLinkData.getTargetUri().getQuery();
                }
        );
    }
}
