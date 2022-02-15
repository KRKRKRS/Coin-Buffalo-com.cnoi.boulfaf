package com.cnoi.boulfaf;

import static com.cnoi.boulfaf.ParseboulfafStr.decoboulfafde;

import android.app.Application;

import com.appsflyer.AppsFlyerLib;
import com.onesignal.OneSignal;

public class ApplboulfafClss extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(decoboulfafde(ParseboulfafStr.OneSiboulfafgnalId));

        MyAppboulfafener MAF = new MyAppboulfafener();
        AppsFlyerLib.getInstance().init(decoboulfafde(ParseboulfafStr.AFKboulfafey), MAF, this);
        AppsFlyerLib.getInstance().start(this);
        C9B.ApboulfafId = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
    }
}
