package com.clover.androidmvpframe.mvp.login.contract;

import com.clover.androidmvpframe.Base.BasePresenter;
import com.clover.androidmvpframe.Base.IBaseView;
import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.mvp.login.model.LoginModelImpl;

public interface LoginContract {


    /**
     * @content:
     * @author: clover
     * @time: 19-1-3 下午3:32
     */
    interface View extends IBaseView {

        //加载进度条
        void showLoading();

        void stopLoading();

        void complete(boolean bol);

        void checkUsername(boolean bol);

        void checkPassword(boolean bol);

    }

    abstract class Presenter extends BasePresenter<View, LoginModelImpl> {

        public abstract void login(User user);

        public abstract boolean checkPassword(User user);

        public abstract boolean checkUsername(User user);
    }

}
