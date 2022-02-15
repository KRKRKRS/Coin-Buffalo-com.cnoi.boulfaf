package com.cnoi.boulfaf;

import static com.cnoi.boulfaf.ParseboulfafStr.decoboulfafde;

import com.appsflyer.AppsFlyerConversionListener;

import java.util.Map;
import java.util.Objects;

public class MyAppboulfafener implements AppsFlyerConversionListener {
    @Override
    public void onConversionDataSuccess(Map<String, Object> map) {
        for (String attrName : map.keySet())
            C9B.statuboulfafFlyer = Objects.requireNonNull(map.get(decoboulfafde("YWZfc3RhdHVz"))).toString();
        if (C9B.statuboulfafFlyer.equals(decoboulfafde("Tm9uLW9yZ2FuaWM="))) {
            String campaignStr = Objects.requireNonNull(map.get(decoboulfafde("Y2FtcGFpZ24="))).toString();
            ParseboulfafStr parserStr = new ParseboulfafStr();
            C9B.strboulfaflyer = parserStr.pboulfafarse(campaignStr);
        }
    }

    @Override
    public void onConversionDataFail(String s) {
    }

    @Override
    public void onAppOpenAttribution(Map<String, String> map) {
    }

    @Override
    public void onAttributionFailure(String s) {
    }
}