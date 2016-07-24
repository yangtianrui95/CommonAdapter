# CommonAdapter

对BaseAdapter进行了封装,提供了共用的ViewHolder类,方便AdapterView的绑定数据.

## 使用方式

以匿名内部类的形式调用
```
 mLvList.setAdapter(new CommonAdapter<String>(MainActivity.this, mDatas, R.layout.item_list) {
            @Override
            protected void convert(ViewHolder holder, String item) {
                TextView tv = holder.getView(R.id.id_tv_text);
                tv.setText(item);
            }
        });
```

在convert()中实现对数据的绑定.