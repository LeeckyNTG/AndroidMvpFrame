package com.clover.androidmvpframe.model.login;


import com.clover.androidmvpframe.bean.User;

public interface ILoginModel {

    public void login(LoginOnLoadListener listener);


    interface LoginOnLoadListener {

        public void onComplete(User user);

    }
}
