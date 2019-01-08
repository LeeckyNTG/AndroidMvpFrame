package com.clover.androidmvpframe.mvp.login.activity;

import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.clover.androidmvpframe.Base.BaseActivity;
import com.clover.androidmvpframe.R;
import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.mvp.login.contract.LoginContract;
import com.clover.androidmvpframe.mvp.login.presenter.LoginPresenter;
import com.clover.androidmvpframe.widget.IconView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {


    @BindView(R.id.username)
    AutoCompleteTextView username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.icon)
    IconView icon;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;

    @OnClick(R.id.login)
    public void onViewClicked() {
        User user = new User();
        user.setUsername(username.getText().toString().trim());
        user.setPassword(password.getText().toString().trim());
        mPresenter.login(user);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginContract.View createView() {
        return this;
    }

    @Override
    public void init() {
    }

    @Override
    public void showLoading() {
        Log.e("login", "showLoading: 登录中...");
    }

    @Override
    public void stopLoading() {
        Log.e("login", "showLoading: 登录结果返回...");
    }

    @Override
    public void complete(boolean bol) {
        if (bol) {
            Log.e("login", "showLoading: 登录成功...");
        } else {
            Log.e("login", "showLoading: 登录失败...");
        }
    }

    @Override
    public void checkUsername(boolean bol) {
        if (!bol)
            Log.e("login", "showLoading: 用户名不符合规范...");
    }

    @Override
    public void checkPassword(boolean bol) {
        if (!bol)
            Log.e("login", "showLoading: 密码不符合规范...");
    }
}

