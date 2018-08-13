package com.application.limitless.sourav.showcaseprojects.ui.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.ui.adapter.ProfileGridAdapter;
import com.application.limitless.sourav.showcaseprojects.ui.base.component.ShadowRectLayout;
import com.application.limitless.sourav.showcaseprojects.ui.utils.Utils;

import static com.application.limitless.sourav.showcaseprojects.ui.utils.Utils.dpToPixel;
import static com.application.limitless.sourav.showcaseprojects.ui.utils.Utils.getScreenWidth;

public class PofileActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getProfileView());

    }


    public View getProfileView() {
        Toolbar toolbar = new Toolbar(this);
        LinearLayout.LayoutParams toolbar_param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pure_white));
        toolbar.setLayoutParams(toolbar_param);
        toolbar.setContentInsetStartWithNavigation(0);
        toolbar.setContentInsetsAbsolute(0, 0);

        toolbar.addView(getToobarLayout());
        LinearLayout clLinearLayout = new LinearLayout(this);
        DrawerLayout.LayoutParams clLinearLayout_param = new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        clLinearLayout.setOrientation(LinearLayout.VERTICAL);
        clLinearLayout.setGravity(Gravity.CENTER);
        clLinearLayout.setLayoutParams(clLinearLayout_param);
        clLinearLayout.addView(toolbar);

        clLinearLayout.addView(getContentLayout());



        return clLinearLayout;
    }


    public LinearLayout getToobarLayout() {
        LinearLayout toobarLayout = new LinearLayout(this);
        toobarLayout.setGravity(Gravity.CENTER);
        toobarLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        imageView.setId(R.id.back_arrow);
        imageView.setPadding(dpToPixel(10), dpToPixel(10), dpToPixel(10), dpToPixel(10));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.setOnClickListener(this);

        TextView headText = new TextView(this);
//        headText.setPadding(dpToPixel(10f), dpToPixel(8f), dpToPixel(10f), dpToPixel(8f));
        headText.setPadding(0, 0, 18 * 2, 0);
        headText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        headText.setGravity(Gravity.CENTER);
        headText.setText("Profile");
        headText.setMaxLines(1);
        headText.setCompoundDrawablePadding(dpToPixel(8));
        headText.setTextColor(getResources().getColor(R.color.text_color));
        headText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        headText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//        headText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_hamburger), null, null, null);

        SearchView searchView = new SearchView(this);
        searchView.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        searchView.setPadding(dpToPixel(10), dpToPixel(10), dpToPixel(10), dpToPixel(10));


        toobarLayout.addView(imageView);
        toobarLayout.addView(headText);
        toobarLayout.addView(searchView);
        return toobarLayout;
    }


    public LinearLayout getContentLayout() {
        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        contentLayout.setBackgroundColor(0xfff1f4f9);
        contentLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ShadowRectLayout shadowRectLayout = new ShadowRectLayout(this);
        shadowRectLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600));
        shadowRectLayout.setShadowColor(0xFFBEBEBE);

        shadowRectLayout.setOffSetY(20);
        shadowRectLayout.setShadowTop(false);
        shadowRectLayout.setShadowLeft(false);
        shadowRectLayout.setRoundCornerRadius(50);
        shadowRectLayout.setShadowRight(false);

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        linearLayoutParam.setMargins(0, -65, 0, 0);
        linearLayout.setLayoutParams(linearLayoutParam);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setPadding(0, 80, 0, 30);

        ImageView imageRounded = new ImageView(this);
        imageRounded.setLayoutParams(new LinearLayout.LayoutParams((int) (getScreenWidth() *0.3), (int) (getScreenWidth() *0.3)));
        imageRounded.setImageResource(R.drawable.profile_man);

        ShadowRectLayout shadowRectLayout1=new ShadowRectLayout(this);
        shadowRectLayout1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        shadowRectLayout1.setRoundCornerRadius((int) (getScreenWidth() *0.3));
        shadowRectLayout1.addView(imageRounded);
        shadowRectLayout1.setOffSetY(5);
        shadowRectLayout1.setShadowColor(Color.GRAY);


        TextView tvProfileName = new TextView(this);
        tvProfileName.setTypeface(Typeface.DEFAULT_BOLD);
        tvProfileName.setGravity(Gravity.CENTER);
        tvProfileName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tvProfileName.setText("LLija Maskov");
        tvProfileName.setPadding(0, 0, 15, 0);
        tvProfileName.setTextColor(Color.DKGRAY);

        TextView tvsubText = new TextView(this);
        tvsubText.setTypeface(Typeface.DEFAULT_BOLD);
        tvsubText.setText("User Interface Designer");
        tvsubText.setGravity(Gravity.CENTER);
        tvsubText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//        tvsubText.setPadding(0, 0, 15, 0);
        tvsubText.setTextColor(Color.LTGRAY);


        linearLayout.addView(shadowRectLayout1);
        linearLayout.addView(tvProfileName);
        linearLayout.addView(tvsubText);
        shadowRectLayout.addView(linearLayout);

        ProfileGridAdapter profileGridAdapter = new ProfileGridAdapter(this);


        contentLayout.addView(shadowRectLayout);
        contentLayout.addView(setLabeledHeader(profileGridAdapter, "Statistics", R.id.session, R.drawable.ic_seriese, R.drawable.ic_right_arrow));

        return contentLayout;
    }

    private LinearLayout setLabeledHeader(RecyclerView.Adapter adapter, String sLable, int lableId, int drawableLeft, int drawableRight) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParam=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        linearLayoutParam.setMargins(0,10,0,0);
        linearLayout.setLayoutParams(linearLayoutParam);
//        linearLayout.setPadding(0, 0, 0, 30);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);

        TextView headText = new TextView(this);
        headText.setPadding(dpToPixel(10f), 0, dpToPixel(10f), 0);
        headText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        headText.setGravity(Gravity.CENTER_VERTICAL);
        headText.setId(lableId);
        headText.setText(sLable);
        headText.setCompoundDrawablePadding(dpToPixel(8));
        headText.setTextColor(getResources().getColor(R.color.text_color));
        headText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        headText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        headText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(drawableLeft), null, getResources().getDrawable(drawableRight), null);


        RecyclerView recyclerView = new RecyclerView(this);

        LinearLayout.LayoutParams recyclerViewParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        recyclerViewParam.setMargins(0, 0, 0, 30);
        recyclerView.setLayoutParams(recyclerViewParam);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        linearLayout.addView(headText);
        linearLayout.addView(recyclerView);

        return linearLayout;


    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.back_arrow){
            this.finish();
        }
    }
}
