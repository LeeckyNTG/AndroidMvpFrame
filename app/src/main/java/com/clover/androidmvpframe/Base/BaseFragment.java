package com.clover.androidmvpframe.Base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 */
public abstract class BaseFragment<V extends IBaseView, P extends BasePresenter> extends RxFragment {

    //引用V层和P层
    private P mPresenter;
    private V mView;
    public Context mContext;

    public P getmPresenter() {
        return mPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mContext = getActivity();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (this.mView == null) {
            this.mView = createView();
        }
        if (mPresenter != null && view != null) {
            mPresenter.onAttachedView(this.mView);
        }
        init();
        return view;
    }

    //由子类指定具体类型
    public abstract int getLayoutId();
    public abstract P createPresenter();
    public abstract V createView();
    public abstract void init();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDetached();
        }
    }
}