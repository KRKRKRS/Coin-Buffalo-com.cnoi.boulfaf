package com.cnoi.boulfaf;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Gistboulfafpi {

    @GET(ParseboulfafStr.GisboulfaftLink)
    Call<ResponseBody> getStrboulfafingUrl();

}
