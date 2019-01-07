package com.clover.androidmvpframe.mvp.login.presenter;


import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.mvp.login.contract.LoginContract;
import com.clover.androidmvpframe.mvp.login.model.ILoginModel;
import com.clover.androidmvpframe.mvp.login.model.LoginModelImpl;


public class LoginPresenter extends LoginContract.Presenter {


    public LoginPresenter(LoginContract.View loginView) {
        mModel = new LoginModelImpl();
        mView = loginView;
    }

    @Override
    public void login(final User user) {

        boolean isUsername = checkUsername(user);
        boolean isPassword = checkPassword(user);

        if (!isUsername) {
            mView.checkUsername(false);
            return;
        }
        if (!isPassword) {
            mView.checkPassword(false);
            return;
        }

        mView.showLoading();

        mModel.login(new ILoginModel.LoginOnLoadListener() {

            @Override
            public void onComplete(User user1) {
                mView.stopLoading();
                if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword())) {
                    mView.complete(true);
                } else {
                    mView.complete(false);
                }
            }
        });
    }

    @Override
    public boolean checkPassword(User user) {
        if (user.getPassword().length() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkUsername(User user) {
        if (user.getUsername().length() >= 5) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onAttached() {

    }
}