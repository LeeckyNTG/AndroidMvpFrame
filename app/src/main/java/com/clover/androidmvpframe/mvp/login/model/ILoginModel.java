package com.clover.androidmvpframe.mvp.login.model;


import com.clover.androidmvpframe.greendao.bean.User;

import java.util.List;

public interface ILoginModel {

    void login(LoginOnLoadListener listener);


    interface LoginOnLoadListener {

        void onComplete(List<User> users);

    }
}
