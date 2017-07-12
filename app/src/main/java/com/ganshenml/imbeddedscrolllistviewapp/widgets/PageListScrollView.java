package com.ganshenml.imbeddedscrolllistviewapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PageListScrollView extends ScrollView {
    private OnScrollToBottomListener mOnScrollToBottomListener;
    private OnScrollHeightListener mOnScrollHeightListener;


    public PageListScrollView(Context context) {
        super(context);
    }

    public PageListScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PageListScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //将高度传出去
        if (mOnScrollHeightListener != null) {
            mOnScrollHeightListener.onScrollHeight(t);
        }
    }


    //滚动到底部时，clampedY变为true，此时将回调将状态传出去
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (scrollY != 0 && mOnScrollToBottomListener != null) {
            mOnScrollToBottomListener.onScrollBottomListener(clampedY);
        }
    }


    public void setOnScrollToBottomListener(OnScrollToBottomListener listener) {
        mOnScrollToBottomListener = listener;
    }

    public interface OnScrollToBottomListener {
        void onScrollBottomListener(boolean isBottom);
    }


    //复杂实现方式，将滚动距离传出去，获取滚动的位置，来判断也可
    public interface OnScrollHeightListener {
        void onScrollHeight(int scrollY);
    }

    public void setOnScrollHeightListener(OnScrollHeightListener onScrollHeightListener) {
        mOnScrollHeightListener = onScrollHeightListener;
    }
}
