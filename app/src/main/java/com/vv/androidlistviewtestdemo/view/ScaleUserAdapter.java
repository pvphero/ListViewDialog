package com.vv.androidlistviewtestdemo.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vv.androidlistviewtestdemo.R;
import com.vv.androidlistviewtestdemo.model.ScaleUserItem;
import com.vv.androidlistviewtestdemo.model.UserType;

import java.util.List;

/**
 * Created by ShenZhenWei on 18/3/29.
 */
public class ScaleUserAdapter extends BaseAdapter {
    private Context context;
    private List<ScaleUserItem> list;

    public ScaleUserAdapter(Context context) {
        setContext(context);
    }

    @Override
    public int getCount() {
        return getList() == null ? 0 : getList().size();
    }

    @Override
    public ScaleUserItem getItem(int i) {
        return getList() == null ? null : getList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        public TextView userNameTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(getContext(), R.layout.setting_mydevice_hs5_delete_item, null);
            viewHolder.userNameTextView = (TextView) convertView.findViewById(R.id.tv_shortcut_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ScaleUserItem userItem = getItem(position);
        if (null != userItem) {
            String userLabel = getContext().getResources().getString(R.string.hs5_delete_user);
            userLabel += (userItem.getPosition() + 1);
            if (userItem.getUserType() == UserType.CURRENT_USER) {
                userLabel += getContext().getResources().getString(R.string.hs5_delete_user_me);
            }
            viewHolder.userNameTextView.setText(userLabel);
        } else {
            viewHolder.userNameTextView.setText("");
        }

        return convertView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ScaleUserItem> getList() {
        return list;
    }

    public void setList(List<ScaleUserItem> list) {
        this.list = list;
    }
}
