package com.developnetwork.mahmoud.service.server;

import com.developnetwork.mahmoud.service.models.ProductModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface ApiInterface {
    @GET("products")
    Call<ProductModel.GetProducts> GET_PRODUCTS_CALL(@HeaderMap HashMap<String, String> header);
}
