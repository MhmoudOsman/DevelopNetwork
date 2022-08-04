package com.developnetwork.mahmoud.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.developnetwork.mahmoud.service.models.ProductModel;
import com.developnetwork.mahmoud.service.repo.ServerRepo;

import java.util.List;

public class HomeViewModel extends ViewModel {
    public LiveData<List<ProductModel>> ProductObservable() {
        return ServerRepo.getINSTANCE().Products();
    }
}