package com.developnetwork.mahmoud;


import static com.developnetwork.mahmoud.tools.Utils.setDarkMode;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        setDarkMode(false);
        super.attachBaseContext(newBase);

    }
}
