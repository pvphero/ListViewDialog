package com.vv.androidlistviewtestdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.vv.androidlistviewtestdemo.widget.ListViewDialog;
import com.vv.androidlistviewtestdemo.R;
import com.vv.androidlistviewtestdemo.model.ScaleUserItem;
import com.vv.androidlistviewtestdemo.widget.SetHeight;
import com.vv.androidlistviewtestdemo.controller.MainActivityController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShenZhenWei on 18/3/29.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private TextView deleteUserTextView;
    private ScaleUserAdapter scaleUserAdapter;
    private SetHeight SetHeight;
    private MainActivityController controller;
    List<ScaleUserItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bindData();
    }

    private void initView() {
        deleteUserTextView = (TextView) findViewById(R.id.hs5_details_delete_user);
        scaleUserAdapter = new ScaleUserAdapter(MainActivity.this);
        SetHeight =new SetHeight();
        controller=new MainActivityController(MainActivity.this);
    }

    private void bindData() {
        list=new ArrayList<>();
        list=controller.getUserList();
        scaleUserAdapter.setList(list);
        deleteUserTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hs5_details_delete_user:
                createUserListDialog();
                Log.e("main", "userList size:" + scaleUserAdapter.getCount());
                break;

        }
    }


    public void createUserListDialog() {
        // 初始化控件属性 设置参数 绑定事件
        final ListViewDialog userListDialog = new ListViewDialog(MainActivity.this);
        userListDialog.setCancelable(true);
        userListDialog.setTitle(getString(R.string.hs5_delete_users));

        userListDialog.getTvCancle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userListDialog.dismiss();
            }
        });
        userListDialog.getmListView().setAdapter(scaleUserAdapter);
        SetHeight.setListViewHeightBasedOnChildren(userListDialog.getmListView(),scaleUserAdapter);
        userListDialog.getmListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,position+"");
            }

        });
        userListDialog.show();
    }
}
