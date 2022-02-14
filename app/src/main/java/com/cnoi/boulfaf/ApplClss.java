package com.cnoi.boulfaf;
import static com.cnoi.boulfaf.ParseStr.decode;

import android.app.Application;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.onesignal.OneSignal;

import java.util.Map;
import java.util.Objects;
public class ApplClss extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(decode(CNSTN.OneSignalId));

        MyAppsFlyerListener MAF = new MyAppsFlyerListener();
        AppsFlyerLib.getInstance().init(decode(CNSTN.AFKey), MAF, this);
        AppsFlyerLib.getInstance().start(this);
        C9B.AppsFl_Id = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
    }


    static class MyAppsFlyerListener implements AppsFlyerConversionListener {
        @Override
        public void onConversionDataSuccess(Map<String, Object> map) {
            for (String attrName : map.keySet())
                C9B.statusAppsFlyer = Objects.requireNonNull(map.get(decode("YWZfc3RhdHVz"))).toString();
            if (C9B.statusAppsFlyer.equals(decode("Tm9uLW9yZ2FuaWM="))) {
                String campaignStr = Objects.requireNonNull(map.get(decode("Y2FtcGFpZ24="))).toString();
                ParseStr parserStr = new ParseStr();
                C9B.strAppsFlyer = parserStr.parse(campaignStr);
            }
        }

        @Override
        public void onConversionDataFail(String s) {
            Log.i("MyApp", "AppsFl onConversionDataFail " + s);

        }

        @Override
        public void onAppOpenAttribution(Map<String, String> map) {
            Log.i("MyApp", "AppsFl onAppOpenAttribution");

        }

        @Override
        public void onAttributionFailure(String s) {
            Log.i("MyApp", "AppsFl onAttributionFailure" + s);

        }
    }
}
