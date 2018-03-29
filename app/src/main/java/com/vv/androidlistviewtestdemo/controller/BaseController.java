package com.vv.androidlistviewtestdemo.controller;

import android.content.Context;

/**
 * Created by ShenZhenWei on 18/3/29.
 */

public abstract class BaseController {
    private boolean isWorking = false;
    private Context context;

    public BaseController(Context context) {
        this.context = context;
        this.init();
    }

    protected abstract void init();

    public void onDestory(){
        onPause();
    }

    public void onResume(){
        setWorking(true);
    }

    private void onPause() {
        setWorking(false);
    }

    private void setWorking(boolean working) {
        isWorking=working;
    }

    public boolean isWorking(){
        return isWorking;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
