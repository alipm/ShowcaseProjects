package com.application.limitless.sourav.showcaseprojects.ui.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class STextView extends android.support.v7.widget.AppCompatTextView{
    public STextView(Context context)
    {
        super(context,null);
    }

    public STextView(Context context, AttributeSet attrs)
    {
        super(context, attrs,0);
    }

    public STextView(Context clContext, AttributeSet attrs, int defStyleAttr)
    {
        super(clContext,attrs,defStyleAttr);
        Typeface type = Typeface.createFromAsset(getResources().getAssets(), "fonts/Larke_Regular.ttf");
        this.setTypeface(type);
    }
}
