package com.developnetwork.mahmoud.ui.homescreen;

import static com.developnetwork.mahmoud.tools.Constant.USER_LOGIN;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.developnetwork.mahmoud.BaseActivity;
import com.developnetwork.mahmoud.Configuration;
import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.databinding.ActivityHomeBinding;
import com.developnetwork.mahmoud.tools.PreferenceManager;
import com.developnetwork.mahmoud.ui.authscreens.AuthActivity;
import com.developnetwork.mahmoud.viewmodel.HomeViewModel;

public class HomeActivity extends BaseActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setSupportActionBar(binding.toolbar);
        viewModel.ProductObservable().observe(this, productModels -> {
            binding.setAdaptor(new ProductAdapter(productModels, this));
            binding.loading.hide();
        });

    }

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        final MenuItem login = menu.findItem(R.id.login_item);
        final MenuItem logout = menu.findItem(R.id.logout_item);
        login.setTitle("Hallo " + Configuration.getCurrent_user().getName());
        logout.setVisible(PreferenceManager.getInstance(getApplicationContext()).contains(USER_LOGIN));
        login.setVisible(PreferenceManager.getInstance(getApplicationContext()).contains(USER_LOGIN));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account:
                if (!PreferenceManager.getInstance(getApplicationContext()).contains(USER_LOGIN)) {
                    startActivity(new Intent(this, AuthActivity.class));
                }
                return true;
            case R.id.logout_item:
                Configuration.setCurrent_user(null);
                PreferenceManager.getInstance(getApplicationContext()).removeData(USER_LOGIN);
                restartActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}