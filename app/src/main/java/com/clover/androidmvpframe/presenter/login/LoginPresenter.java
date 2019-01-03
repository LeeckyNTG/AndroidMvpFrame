package com.clover.androidmvpframe.presenter.login;


import com.clover.androidmvpframe.Base.BasePresenter;
import com.clover.androidmvpframe.model.login.ILoginModel;
import com.clover.androidmvpframe.model.login.LoginModelImpl;
import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.view.login.ILoginView;

public class LoginPresenter extends BasePresenter<ILoginView, LoginModelImpl> {


    public LoginPresenter(ILoginView loginView) {
        mModel = new LoginModelImpl();
        mView = loginView;
    }

    public void login(final User user) {

        mView.showLoading();

        mModel.login(user, new ILoginModel.LoginOnLoadListener() {
            @Override
            public void onSuccess() {
                mView.stopLoading();
                mView.success();
            }

            @Override
            public void onError() {
                mView.stopLoading();
                mView.error();
            }
        });
    }

    @Override
    public void onAttached() {
    }
}
