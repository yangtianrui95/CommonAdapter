package com.terry.commonadapter.common;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangtianrui on 16-7-24.
 * 一个通用的ViewHolder类
 */
public class ViewHolder {
    // 存放View
    private SparseArray<View> mViews = new SparseArray<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mConvertView = mInflater.inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 获取一个ViewHolder对象
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId);
        } else {
            return (ViewHolder) convertView.getTag();
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过Id获取View,没有时添加
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

}
