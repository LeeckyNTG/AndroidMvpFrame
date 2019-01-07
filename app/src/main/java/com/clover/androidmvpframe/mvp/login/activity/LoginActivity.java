package com.clover.androidmvpframe.mvp.login.activity;

import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.clover.androidmvpframe.Base.BaseActivity;
import com.clover.androidmvpframe.R;
import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.mvp.login.contract.LoginContract;
import com.clover.androidmvpframe.mvp.login.presenter.LoginPresenter;


public class LoginActivity extends BaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {


    private AutoCompleteTextView username;

    private EditText password;

    private Button login;

    private TextView icon;


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
        initView();
        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        icon.setTypeface(iconfont);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUsername(username.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());
                mPresenter.login(user);
            }
        });
    }

    private void initView() {

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        icon = findViewById(R.id.icon);

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

