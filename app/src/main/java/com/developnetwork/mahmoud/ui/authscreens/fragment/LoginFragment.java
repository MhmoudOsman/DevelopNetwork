package com.developnetwork.mahmoud.ui.authscreens.fragment;

import static com.developnetwork.mahmoud.tools.Constant.PHONE_PATTERN;
import static com.developnetwork.mahmoud.tools.Constant.PREFERENCE_USER_DATA;
import static com.developnetwork.mahmoud.tools.Constant.USER_LOGIN;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.developnetwork.mahmoud.Configuration;
import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.databinding.FragmentLoginBinding;
import com.developnetwork.mahmoud.service.models.UserModel;
import com.developnetwork.mahmoud.tools.PreferenceManager;
import com.developnetwork.mahmoud.ui.homescreen.HomeActivity;

import java.util.UUID;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment {


    FragmentLoginBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.loginBtn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(binding.phoneInput.getEditText().getText().toString())
                    || binding.phoneInput.getEditText().getText().length() != 11
                    || !Pattern.matches(PHONE_PATTERN, binding.phoneInput.getEditText().getText().toString())
            ) {
                binding.phoneInput.setError(getString(R.string.invalid_phone_number));
            } else if (TextUtils.isEmpty(binding.passInput.getEditText().getText().toString()) || binding.passInput.getEditText().getText().length() < 8) {
                binding.phoneInput.setErrorEnabled(false);
                binding.passInput.setError(getString(R.string.invalid_password));
            } else {
                binding.phoneInput.setErrorEnabled(false);
                binding.passInput.setErrorEnabled(false);
                login();
            }
        });


    }

    private void login() {
        if (PreferenceManager.getInstance(requireContext().getApplicationContext(), PREFERENCE_USER_DATA).contains(binding.phoneInput.getEditText().getText().toString())) {
            Configuration.setCurrent_user((UserModel) PreferenceManager.getInstance(requireContext().getApplicationContext(), PREFERENCE_USER_DATA).fetchObject(binding.phoneInput.getEditText().getText().toString(), UserModel.class));
            if (TextUtils.equals(binding.passInput.getEditText().getText().toString(), Configuration.getCurrent_user().getPass())) {
                String token = UUID.randomUUID().toString();
                Configuration.getCurrent_user().setToken(token);
                PreferenceManager.getInstance(requireContext().getApplicationContext(), PREFERENCE_USER_DATA).saveObject(binding.phoneInput.getEditText().getText().toString(), Configuration.getCurrent_user());
                PreferenceManager.getInstance(requireContext().getApplicationContext()).saveString(USER_LOGIN, binding.phoneInput.getEditText().getText().toString());
                startActivity(new Intent(getContext(), HomeActivity.class));
                requireActivity().finish();

            } else {
                binding.passInput.setError(getString(R.string.invalid_password));
            }
        } else {
            binding.phoneInput.setError(getString(R.string.invalid_phone_number));
        }
    }
}