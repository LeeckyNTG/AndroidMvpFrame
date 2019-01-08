package com.clover.androidmvpframe.Base;

import android.app.Application;
import android.content.Context;

import com.clover.androidmvpframe.bean.Config;
import com.clover.androidmvpframe.greendao.DaoMaster;
import com.clover.androidmvpframe.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class BaseApplication extends Application {


    private static Context mContext;
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initGreenDao(mContext);
    }

    private void init() {
        mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }

    public void initGreenDao(Context context) {

        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context, Config.DATA_BASE_NAME);
        Database db = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }
}
