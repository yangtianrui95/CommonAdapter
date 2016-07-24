package com.terry.commonadapter.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by yangtianrui on 16-7-24.
 * 通用Adapter
 * <p/>
 * 构造特定的Adapter,只需重写此Convert方法即可
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected List<T> mList;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected final int mLayoutId;

    public CommonAdapter(Context context, List<T> list, int layoutId) {
        mList = list;
        mLayoutId = layoutId;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, viewGroup, mLayoutId);
        convert(holder, mList.get(position));
        convertView = holder.getConvertView();
        return convertView;
    }

    /**
     * 获取ConvertView并绑定数据
     */
    abstract protected void convert(ViewHolder holder, T item);
}
