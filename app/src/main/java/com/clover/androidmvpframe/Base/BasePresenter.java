package com.clover.androidmvpframe.Base;

/**
 * Created by  lik on 16/4/22.
 */
public abstract class BasePresenter<V, M> {

    protected V mView;

    protected M mModel;

    public void onAttachedView(V v) {
        this.mView = v;
        this.onAttached();
    }

    public abstract void onAttached();

    public void onDetached() {

        /**
         * 避免内存泄漏
         */
        mView = null;
        mModel = null;
    }
}
