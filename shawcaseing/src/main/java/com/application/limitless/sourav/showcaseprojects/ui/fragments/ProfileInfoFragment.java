package com.application.limitless.sourav.showcaseprojects.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.ui.base.component.ShadowRectLayout;
import com.application.limitless.sourav.showcaseprojects.ui.utils.STextView;
import com.application.limitless.sourav.showcaseprojects.ui.utils.Utils;

@SuppressLint("ValidFragment")
public class ProfileInfoFragment extends Fragment {


    private final Context clContext;
    private int i3dp;
    private int i10dp;
    private int i5dp;
    private int i20dp;
    private int i40dp;

    public ProfileInfoFragment(Context clContext)
    {
        this.clContext = clContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return getProfileView();

    }

    public View getProfileView()
    {
        LinearLayout profileLayout = new LinearLayout(clContext);
        profileLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        profileLayout.setOrientation(LinearLayout.VERTICAL);

        profileLayout.addView(getScrollableContent());
        profileLayout.addView(getIcontLayout());
        return profileLayout;
    }

    public ScrollView getScrollableContent()
    {
        i3dp = Utils.dpToPixel(3);
        i5dp = Utils.dpToPixel(5);
        i10dp = Utils.dpToPixel(10);
        i20dp = Utils.dpToPixel(20);
        i40dp = Utils.dpToPixel(40);
        ScrollView scrollableContent = new ScrollView(clContext);
        scrollableContent.setFillViewport(true);
        scrollableContent.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
        LinearLayout linearLayout = new LinearLayout(clContext);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.about_background));
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setPadding(i10dp, i10dp, i10dp, i20dp);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView ivProfile = new ImageView(clContext);
        ivProfile.setLayoutParams(new LinearLayout.LayoutParams(Utils.dpToPixel(250), Utils.dpToPixel(250)));
        ivProfile.setImageResource(R.drawable.ic_profile_icon);

        STextView tvHeading = new STextView(clContext);
        tvHeading.setText("Independent Product Designer");
        tvHeading.setTextColor(Color.DKGRAY);
        tvHeading.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        tvHeading.setTypeface(Typeface.DEFAULT_BOLD);

        STextView tvKnowMore = new STextView(clContext);
        tvKnowMore.setText("Know More");
        tvKnowMore.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvKnowMore.setTypeface(Typeface.DEFAULT_BOLD);
        tvKnowMore.setOnClickListener(new DialogEventClickListener());
        tvKnowMore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tvKnowMore.setTextColor(Utils.getColorStateListDrawable(Color.GRAY, Color.DKGRAY));


        STextView tvDiscription = new STextView(clContext);
        tvDiscription.setText(R.string.about_page_text);
        tvDiscription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tvDiscription.setTextColor(Color.GRAY);
        //        tvDiscription.setTypeface(Typeface.DEFAULT_BOLD);


        ShadowRectLayout shadowRectLayout = new ShadowRectLayout(clContext);
        shadowRectLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        shadowRectLayout.setOffSetY(15);
        shadowRectLayout.setOffSetX(0);
        shadowRectLayout.setShadowRadius(20);
        shadowRectLayout.setShadowColor(0xbfaaa5fc);
        shadowRectLayout.setImgGradientColor1(getResources().getColor(R.color.about_purple));
        shadowRectLayout.setId(R.id.hire_me_layout);
        //        shadowRectLayout.setImgGradientColor2(getResources().getColor(R.color.about_purple));
        shadowRectLayout.setOnClickListener(new DialogEventClickListener());
        shadowRectLayout.setRoundCornerRadius(i40dp);
        STextView textView = new STextView(clContext);
        textView.setText("Hire Me");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(i40dp, i10dp, i40dp, i10dp);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        shadowRectLayout.addView(textView);

        linearLayout.addView(ivProfile);
        linearLayout.addView(tvHeading);
        linearLayout.addView(tvDiscription);
        linearLayout.addView(shadowRectLayout);
        linearLayout.addView(tvKnowMore);


        scrollableContent.addView(linearLayout);
        return scrollableContent;
    }


    public LinearLayout getIcontLayout()
    {
        LinearLayout linearLayout = new LinearLayout(clContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setPadding(i10dp, i10dp, i10dp, i20dp);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setBackgroundColor(Color.WHITE);
        linearLayout.addView(getIconSet(R.drawable.ic_dribble_big_logo, 5.5f));
        linearLayout.addView(getIconSet(R.drawable.ic_instagram_logo, 15.5f));
        linearLayout.addView(getIconSet(R.drawable.ic_twitter, 1.6f));
        linearLayout.addView(getIconSet(R.drawable.ic_facebook, 1.3f));
        return linearLayout;
    }

    public LinearLayout getIconSet(@DrawableRes int imgResource, float fFloat)
    {
        LinearLayout linearLayout = new LinearLayout(clContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        LinearLayout.LayoutParams linearLayoutpram = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayoutpram.setMargins(i10dp, i10dp, i10dp, i10dp);
        linearLayout.setLayoutParams(linearLayoutpram);

        STextView tvFollower = new STextView(clContext);
        tvFollower.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        tvFollower.setTextColor(Color.GRAY);
        //        tvFollower.setTypeface(Typeface.DEFAULT_BOLD);
        tvFollower.setGravity(Gravity.CENTER);
        tvFollower.setText(String.valueOf(fFloat) + "K");

        ImageView ivIcon = new ImageView(clContext);
        LinearLayout.LayoutParams iconIvParam = new LinearLayout.LayoutParams(Utils.dpToPixel(42), Utils.dpToPixel(42));
        ivIcon.setPadding(i5dp, i5dp, i5dp, i5dp);
        Drawable icon = Utils.getIcon(clContext, imgResource, Color.DKGRAY);
        ivIcon.setImageDrawable(icon);
        ivIcon.setBackground(Utils.getRoundDrawableListState(Color.TRANSPARENT, 32f, getResources().getColor(R.color.about_text), 32));
        ivIcon.setOnClickListener(new ProfileInfoFragment.DialogEventClickListener());
        ivIcon.setLayoutParams(iconIvParam);
        linearLayout.addView(ivIcon);
        linearLayout.addView(tvFollower);

        return linearLayout;
    }

    private class DialogEventClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view)
        {
            if (view.getId() == R.id.hire_me_layout)
            {

                AboutExtraDialog clNewNoteDialog = new AboutExtraDialog(clContext);
                FragmentManager clFragmentManager = ((AppCompatActivity) clContext).getSupportFragmentManager();
                clNewNoteDialog.show(clFragmentManager, "About");
            }

        }
    }
}
