package com.terry.commonadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.terry.commonadapter.common.CommonAdapter;
import com.terry.commonadapter.common.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLvList;
    private List<String> mDatas = new ArrayList<>();

    // 添加测试数据
    {
        for (int i = 0; i < 50; i++) {
            mDatas.add(i + "");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLvList = (ListView) findViewById(R.id.id_lv_list);
        mLvList.setAdapter(new CommonAdapter<String>(MainActivity.this, mDatas, R.layout.item_list) {
            @Override
            protected void convert(ViewHolder holder, String item) {
                TextView tv = holder.getView(R.id.id_tv_text);
                tv.setText(item);
            }
        });
    }
}
