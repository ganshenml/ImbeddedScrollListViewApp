package com.ganshenml.imbeddedscrolllistviewapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.ganshenml.imbeddedscrolllistviewapp.R;

import java.util.List;

public class ImbeddedListView extends ListView {
    private View footer;// 底部布局
    private boolean isLoading;// 判断是否正在加载中


    public ImbeddedListView(Context context) {
        super(context);
        initView(context);
    }

    public ImbeddedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ImbeddedListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }


    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.listview_footer_view, null);
        footer.findViewById(R.id.loading_layout).setVisibility(View.GONE);
        this.addFooterView(footer);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);//Measure specification mode: The child can be as large as it wants up to the specified size.——>处理ScrollView嵌套ListView只显示一行的问题，此处让ListView所占的大小与要求的大小一样大
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


    /**
     * 加载完成，1.设置标志；2.隐藏footer
     */
    public void loadComplete() {
        if (footer == null) {
            return;
        }
        isLoading = false;
        footer.findViewById(R.id.loading_layout).setVisibility(View.GONE);
    }

    /**
     * 开始加载，1.设置标志；2.显示footer
     */
    public void startLoading() {
        if (footer == null) {
            return;
        }
        isLoading = true;
        footer.findViewById(R.id.loading_layout).setVisibility(VISIBLE);
    }

    public boolean isLoading() {
        return isLoading;
    }

}
