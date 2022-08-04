package com.developnetwork.mahmoud.tools;

import androidx.appcompat.app.AppCompatDelegate;

public class Utils {
    public static void setDarkMode(Boolean darkMood) {
        if (darkMood) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}
