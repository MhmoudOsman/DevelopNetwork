package com.developnetwork.mahmoud.ui.splashscreen;

import static com.developnetwork.mahmoud.tools.Constant.PREFERENCE_USER_DATA;
import static com.developnetwork.mahmoud.tools.Constant.USER_LOGIN;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.databinding.DataBindingUtil;

import com.developnetwork.mahmoud.BaseActivity;
import com.developnetwork.mahmoud.Configuration;
import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.databinding.ActivitySplashBinding;
import com.developnetwork.mahmoud.service.models.UserModel;
import com.developnetwork.mahmoud.tools.PreferenceManager;
import com.developnetwork.mahmoud.ui.homescreen.HomeActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        startSplash();
    }

    void startSplash() {
        new Handler().postDelayed(() -> {
            if (PreferenceManager.getInstance(getApplicationContext()).contains(USER_LOGIN)) {
                String id = PreferenceManager.getInstance(getApplicationContext()).fetchString(USER_LOGIN);
                Configuration.setCurrent_user((UserModel) PreferenceManager.getInstance(getApplicationContext(), PREFERENCE_USER_DATA).fetchObject(id, UserModel.class));
            }
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }, 2000);
    }

}