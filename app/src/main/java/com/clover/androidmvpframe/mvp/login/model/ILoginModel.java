package com.clover.androidmvpframe.mvp.login.model;


import com.clover.androidmvpframe.bean.User;

public interface ILoginModel {

    void login(LoginOnLoadListener listener);


    interface LoginOnLoadListener {

        void onComplete(User user);

    }
}
