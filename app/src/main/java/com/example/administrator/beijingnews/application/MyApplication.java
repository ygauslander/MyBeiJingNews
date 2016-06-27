package com.example.administrator.beijingnews.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}
