package com.developnetwork.mahmoud.service.server;

import static com.developnetwork.mahmoud.tools.Constant.BASE_SERVER_LINK;

import com.developnetwork.mahmoud.Configuration;
import com.developnetwork.mahmoud.service.models.ProductModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Client INSTANCE;
    private final ApiInterface apiInterface;

    public Client() {
        apiInterface = retrofitBuilder().create(ApiInterface.class);
    }

    public static Retrofit retrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(BASE_SERVER_LINK)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Client getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new Client();
        }
        return INSTANCE;
    }

    private HashMap<String, String> headers() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("token", Configuration.getCurrent_user().getToken());
        return headers;
    }

    public Call<ProductModel.GetProducts> getProduct() {
        return apiInterface.GET_PRODUCTS_CALL(headers());
    }

}
