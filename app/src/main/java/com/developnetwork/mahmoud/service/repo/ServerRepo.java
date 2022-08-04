package com.developnetwork.mahmoud.service.repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.developnetwork.mahmoud.service.models.ProductModel;
import com.developnetwork.mahmoud.service.server.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerRepo {
    private static ServerRepo INSTANCE;

    public static ServerRepo getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new ServerRepo();
        }
        return INSTANCE;
    }

    public LiveData<List<ProductModel>> Products() {
        MutableLiveData<List<ProductModel>> LiveData = new MutableLiveData<>();
        Client.getINSTANCE().getProduct().enqueue(new Callback<ProductModel.GetProducts>() {
            @Override
            public void onResponse(@NonNull Call<ProductModel.GetProducts> call, @NonNull Response<ProductModel.GetProducts> response) {
                if (response.body() != null) {
                    LiveData.setValue(response.body().getProducts());
                } else {
                    Log.println(Log.ASSERT, "message", response.message());
                    Log.println(Log.ASSERT, "response", response.toString());

                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductModel.GetProducts> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
        return LiveData;
    }

}
