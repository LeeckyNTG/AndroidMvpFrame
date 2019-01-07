package com.clover.androidmvpframe.mvp.login.model;


import com.clover.androidmvpframe.bean.User;

public class LoginModelImpl implements ILoginModel {

    @Override
    public void login(LoginOnLoadListener listener) {

        User user = getUser();

        listener.onComplete(user);

    }

    private User getUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        return user;
    }
}
