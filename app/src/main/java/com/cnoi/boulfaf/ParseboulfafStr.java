package com.cnoi.boulfaf;

import static com.cnoi.boulfaf.C9B.ApboulfafId;
import static com.cnoi.boulfaf.C9B.keyDboulfafult;
import static com.cnoi.boulfaf.FboulfafK.AD_boulfafD;

import com.onesignal.OneSignal;

public class ParseboulfafStr {

    public static final String GisboulfaftLink = "https://gist.githubusercontent.com/KRKRKRS/a70f4aa17b103671026206838a472fb2/raw/Coin%2520Buffalo%2520%257C%2520com.cnoi.boulfaf/";
    public static final String AFKboulfafey = "RTlVUnBWZERQRWZqV0F0ZVU3aGdnSA==";
    public static final String OneSiboulfafgnalId = "ZGMwNGY4NTgtZmI5MS00ODdiLTg2ZDQtZmM2YWFlZDYwYmJh";

    String[] kboulfafeys = {decoboulfafde("Pw=="), decoboulfafde("JnN1YjY9"), decoboulfafde("JnN1Yjc9"), decoboulfafde("JnN1YjI9"), decoboulfafde("JnN1YjM9"), decoboulfafde("JnN1YjQ9"), decoboulfafde("JnN1YjU9")};

    String pboulfafarse(String inpboulfafut) {
        String[] paraboulfafms = inpboulfafut.split("::");
        StringBuilder resuboulfaflt = new StringBuilder();
        resuboulfaflt.append(paraboulfafms[0]).append("?")
                .append(decoboulfafde("YnVuZGxlPQ==")).append("com.cnoi.boulfaf")
                .append(decoboulfafde("JmFkX2lkPQ==")).append(AD_boulfafD)
                .append(decoboulfafde("JmFwcHNfaWQ9")).append(ApboulfafId)
                .append(decoboulfafde("JmRldl9rZXk9")).append(decoboulfafde(ParseboulfafStr.AFKboulfafey));

        for (int i = 1; i < paraboulfafms.length; i++) {
            resuboulfaflt.append(kboulfafeys[i]).append(paraboulfafms[i]);
        }

        String teamboulfafName = paraboulfafms[1];
        OneSignal.sendTag(decoboulfafde("c3ViX2FwcA=="), teamboulfafName);
        return String.valueOf(resuboulfaflt);
    }


    String parsboulfafeOrganic(String inpboulfafut) {
        return inpboulfafut + keyDboulfafult +
                decoboulfafde("P2J1bmRsZT0=") + "com.cnoi.boulfaf" +
                decoboulfafde("JmFkX2lkPQ==") + FboulfafK.AD_boulfafD +
                decoboulfafde("JmFwcHNfaWQ9") + ApboulfafId +
                decoboulfafde("JmRldl9rZXk9") + decoboulfafde(ParseboulfafStr.AFKboulfafey);
    }

    public static String decoboulfafde(String sboulfaftr) {
        byte[] decodedBytes = android.util.Base64.decode(sboulfaftr, android.util.Base64.URL_SAFE | android.util.Base64.NO_PADDING);
        return new String(decodedBytes);
    }
}