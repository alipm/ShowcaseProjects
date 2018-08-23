package com.application.limitless.sourav.showcaseprojects.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.ui.adapter.AboutPagerAdapter;
import com.application.limitless.sourav.showcaseprojects.ui.fragments.ProfileInfoFragment;
import com.application.limitless.sourav.showcaseprojects.ui.utils.STextView;
import com.application.limitless.sourav.showcaseprojects.ui.utils.Utils;

public class AboutActivity extends SBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Utils.setLightStatusBar(this);
        //        Utils.setStatusBarColor(this, Color.BLACK);
        setContentView(aboutTabLayout());
        setupTabIcons();


    }


    private View aboutTabLayout()
    {
        LinearLayout linearLayout = new LinearLayout(this);
        ViewGroup.LayoutParams coordinatorLayoutMain_param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutMode(ViewGroup.LAYOUT_MODE_CLIP_BOUNDS);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(0, Utils.dpToPixel(12), 0, 0);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.about_background));
        linearLayout.setLayoutParams(coordinatorLayoutMain_param);

        AppBarLayout abTabtool = new AppBarLayout(this);
        LinearLayout.LayoutParams ab_tabtool_param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        abTabtool.setLayoutParams(ab_tabtool_param);
        TabLayout tablayout = new TabLayout(this);
        LinearLayout.LayoutParams tab_layout_param = new AppBarLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tablayout.setMinimumWidth(0);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);  // scorllable tab
        tablayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
        tablayout.setSelectedTabIndicatorColor(Color.BLACK);
        tablayout.setTabIndicatorFullWidth(false);
        tablayout.setSelectedTabIndicatorHeight(5);
        tablayout.setBackgroundColor(getResources().getColor(R.color.about_background));
        tablayout.setId(R.id.about_tablayout);
        tablayout.setLayoutParams(tab_layout_param);
        tablayout.setHapticFeedbackEnabled(true);
        tablayout.setMinimumHeight(0);
        tablayout.setMinimumWidth(0);


        ViewPager viewPager = new ViewPager(this);
        tablayout.setupWithViewPager(viewPager);
        viewPager.setId(R.id.about_viewpager);
        setupViewPager(viewPager);
        LinearLayout.LayoutParams viewPager_param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        viewPager.setLayoutParams(viewPager_param);
        abTabtool.addView(tablayout);
        linearLayout.addView(abTabtool);
        linearLayout.addView(viewPager);
        return linearLayout;
    }

    private void setupTabIcons()
    {
        TabLayout tabLayout = findViewById(R.id.about_tablayout);
        tabLayout.getTabAt(0).setCustomView(getCustomTab("About"));
        tabLayout.getTabAt(1).setCustomView(getCustomTab("Portfolio"));
        tabLayout.getTabAt(2).setCustomView(getCustomTab("Lab"));
        tabLayout.getTabAt(3).setCustomView(getCustomTab("Contact"));
    }

    public TextView getCustomTab(String sTitle)
    {
        STextView customTab = new STextView(this);
        customTab.setTextColor(Color.DKGRAY);
        customTab.setText(sTitle);
        customTab.setGravity(Gravity.CENTER);
        return customTab;
    }

    private void setupViewPager(ViewPager viewPager)
    {
        AboutPagerAdapter adapter = new AboutPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ProfileInfoFragment(this), "About");
        adapter.addFrag(new ProfileInfoFragment(this), "Portfolio");
        adapter.addFrag(new ProfileInfoFragment(this), "Lab");
        adapter.addFrag(new ProfileInfoFragment(this), "Contact");
        viewPager.setAdapter(adapter);
    }
}
