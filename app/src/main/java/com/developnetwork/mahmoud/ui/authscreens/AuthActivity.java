package com.developnetwork.mahmoud.ui.authscreens;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.developnetwork.mahmoud.BaseActivity;
import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.databinding.ActivityAuthBinding;

public class AuthActivity extends BaseActivity {
    ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        setUpNav();

    }

    private void setUpNav() {
        binding.authPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), this));
        binding.authTabs.setupWithViewPager(binding.authPager);
    }
}