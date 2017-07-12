package com.ganshenml.imbeddedscrolllistviewapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.ganshenml.imbeddedscrolllistviewapp.R;

public class ImbeddedListView extends ListView implements AbsListView.OnScrollListener {
    private View footer;// 底部布局
    private int totalItemCount;// 总数量
    private int lastVisibleItem;// 最后一个可见的item;
    private boolean isLoading;// 判断变量
    private ILoadListener iLoadListener;// 接口变量

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

    // listview加载底部布局
    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.listview_footer_view, null);
        // 设置隐藏底部布局
        footer.findViewById(R.id.loading_layout).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);//Measure specification mode: The child can be as large as it wants up to the specified size.——>处理ScrollView嵌套ListView只显示一行的问题，此处让ListView所占的大小与要求的大小一样大
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (totalItemCount == lastVisibleItem && scrollState == SCROLL_STATE_IDLE) {
            if (!isLoading) {
                isLoading = true;
                footer.findViewById(R.id.loading_layout).setVisibility(View.VISIBLE);
                iLoadListener.onLoad();// 加载更多（获取接口）
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastVisibleItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }



    // 加载完成通知隐藏
    public void loadComplete() {
        if (footer == null) {
            return;
        }
        isLoading = false;
        footer.findViewById(R.id.loading_layout).setVisibility(View.GONE);
    }

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

    public void setInterface(ILoadListener iLoadListener) {
        this.iLoadListener = iLoadListener;
    }

    // 加载更多数据的回调接口
    public interface ILoadListener {
        void onLoad();
    }
}
