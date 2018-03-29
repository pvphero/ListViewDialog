package com.vv.androidlistviewtestdemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.vv.androidlistviewtestdemo.R;

/**
 * Created by ShenZhenWei on 18/3/29.
 */

public class ListViewDialog extends Dialog {

    private final Context mContext;
    private ListView mListView;
    private TextView tvCancle;

    public ListViewDialog(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    private void initView() {
        View contentView = View.inflate(mContext, R.layout.list_view, null);
        mListView = (ListView) contentView.findViewById(R.id.lv_remain_item);
        tvCancle=contentView.findViewById(R.id.txt_cancel);
        setContentView(contentView);
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        if (!hasFocus) {
//            return;
//        }
//        setHeight();
//        setWidth();
//    }
//
//    private void setHeight() {
//        Window window = getWindow();
//        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        if (window.getDecorView().getHeight() >= (int) (displayMetrics.heightPixels * 0.6)) {
//            attributes.height = (int) (displayMetrics.heightPixels * 0.6);
//        }
//        window.setAttributes(attributes);
//    }
//
//    private void setWidth() {
//        Window window = getWindow();
//        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        if (window.getDecorView().getWidth() >= (int) (displayMetrics.widthPixels * 0.8)) {
//            attributes.width = (int) (displayMetrics.widthPixels * 0.8);
//        }
//        window.setAttributes(attributes);
//    }

    public TextView getTvCancle() {
        return tvCancle;
    }

    public void setTvCancle(TextView tvCancle) {
        this.tvCancle = tvCancle;
    }

    public ListView getmListView() {
        return mListView;
    }

    public void setmListView(ListView mListView) {
        this.mListView = mListView;
    }
}

