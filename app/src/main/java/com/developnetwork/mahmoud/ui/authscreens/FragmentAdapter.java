package com.developnetwork.mahmoud.ui.authscreens;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.ui.authscreens.fragment.LoginFragment;
import com.developnetwork.mahmoud.ui.authscreens.fragment.RegisterFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    Context context;

    public FragmentAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LoginFragment.newInstance();
            case 1:
                return RegisterFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.login);
            case 1:
                return context.getString(R.string.register);
            default:
                return super.getPageTitle(position);
        }

    }
}
