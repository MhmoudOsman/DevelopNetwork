package com.developnetwork.mahmoud;

import com.developnetwork.mahmoud.service.models.UserModel;

public class Configuration {
    private static UserModel current_user;

    public static UserModel getCurrent_user() {
        if (current_user == null) {
            return new UserModel("", "", "", "");
        } else
            return current_user;
    }

    public static void setCurrent_user(UserModel current_user) {
        Configuration.current_user = current_user;
    }
}
