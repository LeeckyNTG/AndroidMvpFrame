package com.clover.androidmvpframe.Base;


import android.os.Bundle;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by qiyue on 2016/4/5.
 */
@SuppressWarnings("unchecked")
public abstract class BaseActivity<V extends IBaseView, P extends BasePresenter> extends RxAppCompatActivity {
    public P mPresenter;
    public V mView;

    //由子类指定具体类型
    public abstract int getLayoutId();
    public abstract P createPresenter();
    public abstract V createView();
    public abstract void init();

    public P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        if(mPresenter == null){
            mPresenter = createPresenter();
        }
        if(mView == null){
            mView = createView();
        }
        if(mPresenter != null && mView != null){
            mPresenter.onAttachedView(mView);
        }
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDetached();
    }
}
