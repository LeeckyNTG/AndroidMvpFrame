package com.clover.androidmvpframe.view.login;


/**
 * @content:
 * @author: clover
 * @time: 19-1-3 下午3:32
 */
public interface ILoginView {

    //加载进度条
    public void showLoading();

    public void stopLoading();

    public void complete(boolean bol);

    public void checkUsername(boolean bol);

    public void checkPassword(boolean bol);

}
