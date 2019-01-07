package com.clover.androidmvpframe.mvp.login.contract;

import com.clover.androidmvpframe.Base.BasePresenter;
import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.mvp.login.model.LoginModelImpl;

public interface LoginContract {


    /**
     * @content:
     * @author: clover
     * @time: 19-1-3 下午3:32
     */
    public interface View {

        //加载进度条
        public void showLoading();

        public void stopLoading();

        public void complete(boolean bol);

        public void checkUsername(boolean bol);

        public void checkPassword(boolean bol);

    }

    public abstract class Presenter extends BasePresenter<View, LoginModelImpl> {

        public abstract void login(User user);

        public abstract boolean checkPassword(User user);

        public abstract boolean checkUsername(User user);
    }

}
