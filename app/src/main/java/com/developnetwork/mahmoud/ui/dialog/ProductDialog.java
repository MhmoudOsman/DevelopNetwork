package com.developnetwork.mahmoud.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.databinding.DialogProductBinding;
import com.developnetwork.mahmoud.service.models.ProductModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ProductDialog extends Dialog {
    public ProductDialog(@NonNull Context context, ProductModel model) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        DialogProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_product, null, false);
        setContentView(binding.getRoot());
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setCanceledOnTouchOutside(true);
        binding.setModel(model);
        if (model.getImages() != null) {
            if (model.getImages().size() > 1) {
                Random random = new Random();
                int i = random.nextInt((model.getImages().size() - 1));
                Picasso.get().load(model.getImages().get(i)).error(R.drawable.no_image).into(binding.pic, new Callback() {
                    @Override
                    public void onSuccess() {
                        binding.loadingImage.hide();
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                        binding.loadingImage.hide();
                    }
                });
            } else {
                Picasso.get().load(model.getImages().get(0)).error(R.drawable.no_image).into(binding.pic, new Callback() {
                    @Override
                    public void onSuccess() {
                        binding.loadingImage.hide();
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                        binding.loadingImage.hide();
                    }
                });
            }
        } else {
            binding.pic.setImageResource(R.drawable.no_image);
            binding.loadingImage.hide();
        }


    }
}
