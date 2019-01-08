package com.clover.androidmvpframe.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @content:文字图标控件自定义
 * @author: clover
 * @time: 19-1-7 下午5:12
 */

@SuppressLint("AppCompatCustomView")
public class IconView extends TextView {

    public IconView(Context context) {
        super(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
        setTypeface(typeface);
    }

}
