package com.example.hyde.spreadsheet;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hyde on 22/03/2018.
 */

public interface ApiInterface {
    @GET("exec?id=13aU-_NuiH7OJ0F2HCoQPdYwX0I728uIL1lTplkXIMyk&sheet=user")
    Call<Response> ambilData();
}
