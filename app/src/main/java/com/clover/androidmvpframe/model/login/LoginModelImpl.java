package com.clover.androidmvpframe.model.login;


import com.clover.androidmvpframe.bean.User;

public class LoginModelImpl implements ILoginModel {

    @Override
    public void login(User user, LoginOnLoadListener listener) {

        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")) {
            listener.onSuccess();
        } else {
            listener.onError();
        }

    }
}
