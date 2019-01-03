package com.clover.androidmvpframe.model.login;


import com.clover.androidmvpframe.bean.User;

public interface ILoginModel {

    public void login(User user, LoginOnLoadListener listener);


    interface LoginOnLoadListener {

        public void onSuccess();

        public void onError();
    }
}
