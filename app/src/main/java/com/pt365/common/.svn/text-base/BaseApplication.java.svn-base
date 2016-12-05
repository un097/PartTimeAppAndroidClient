package com.pt365.common;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;


/**
 * 基础Application
 * Created by suncr on 2016/10/12.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils框架
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
