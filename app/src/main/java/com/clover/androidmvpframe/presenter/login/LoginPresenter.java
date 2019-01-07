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

    private boolean checkPassword(User user) {
        if (user.getPassword().length() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkUsername(User user) {
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
