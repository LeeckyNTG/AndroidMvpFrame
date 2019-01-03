package com.clover.androidmvpframe.Base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



/**
 * Created by qiyue on 2016/4/5.
 */
@SuppressWarnings("unchecked")
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter != null) mPresenter.onAttachedView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDetached();
    }
}
