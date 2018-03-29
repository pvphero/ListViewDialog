package com.vv.androidlistviewtestdemo.controller;

import android.content.Context;

import com.vv.androidlistviewtestdemo.model.ScaleUserItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShenZhenWei on 18/3/29.
 */

public class MainActivityController extends BaseController{

    public MainActivityController(Context context) {
        super(context);
    }

    @Override
    protected void init() {

    }

    public List<ScaleUserItem> getUserList() {
        ArrayList<ScaleUserItem> list = new ArrayList<>();
        ScaleUserItem item;
        for (int i=0;i<7;i++){
            item=new ScaleUserItem();
            item.setPosition(i);
            item.setUserType(i);
            list.add(item);
        }
        return list;
    }
}
