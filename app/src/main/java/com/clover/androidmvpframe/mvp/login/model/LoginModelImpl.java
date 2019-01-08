package com.clover.androidmvpframe.mvp.login.model;


import com.clover.androidmvpframe.Base.BaseApplication;
import com.clover.androidmvpframe.greendao.bean.User;

import java.util.List;

public class LoginModelImpl implements ILoginModel {

    @Override
    public void login(LoginOnLoadListener listener) {

        List<User> users = getUser();
        listener.onComplete(users);

    }

    private List<User> getUser() {

        List<User> users = BaseApplication.getDaoSession().getUserDao().loadAll();
        return users;

    }
}
