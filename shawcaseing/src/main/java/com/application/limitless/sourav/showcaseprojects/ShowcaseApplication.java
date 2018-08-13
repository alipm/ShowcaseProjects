package com.application.limitless.sourav.showcaseprojects;

import android.app.Application;

import com.application.limitless.sourav.showcaseprojects.ui.utils.fontutill.TypefaceUtil;

public class ShowcaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/sugo_regular.otf");

    }
}
