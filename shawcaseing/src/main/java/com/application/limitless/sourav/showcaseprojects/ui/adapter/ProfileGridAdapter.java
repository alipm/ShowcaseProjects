package com.application.limitless.sourav.showcaseprojects.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.ui.base.component.ShadowRectLayout;
import com.application.limitless.sourav.showcaseprojects.ui.utils.Utils;

import static com.application.limitless.sourav.showcaseprojects.ui.utils.Utils.getScreenWidth;

public class ProfileGridAdapter extends RecyclerView.Adapter<ProfileGridAdapter.CardData> {
    final Context mContext;

    public ProfileGridAdapter(Activity mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ProfileGridAdapter.CardData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        int radii = Utils.dpToPixel(15);
//        int radii = 4;
        ShadowRectLayout shadowRectLayout = new ShadowRectLayout(mContext);
//        shadowRectLayout.setClipToPadding(false);
//        shadowRectLayout.setClipToOutline(false);
//        shadowRectLayout.setClipChildren(false);
        shadowRectLayout.setOffSetY(10);
//        shadowRectLayout.setImgGradientColor2(0xD2F47B36);
//        shadowRectLayout.setImgGradientColor1(0xDEC9691B);
//        shadowRectLayout.setResDrawable(R.drawable.metting_img);
        shadowRectLayout.setShadowRadius(25);
        shadowRectLayout.setRoundCornerRadius(20);
        shadowRectLayout.setShadowColor(0xFFBEBEBE);

        LinearLayout linearLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams linearLayoutParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        linearLayoutParam.setMargins(0, -65, 0, 0);
        linearLayout.setLayoutParams(linearLayoutParam);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setPadding(0, 80, 0, 30);

        ImageView imageRounded = new ImageView(mContext);
        imageRounded.setLayoutParams(new LinearLayout.LayoutParams(Utils.dpToPixel(150), Utils.dpToPixel(160)));
        imageRounded.setImageResource(R.drawable.flame);


        TextView tvProfileName = new TextView(mContext);
        tvProfileName.setTypeface(Typeface.DEFAULT_BOLD);
        tvProfileName.setGravity(Gravity.CENTER);
        tvProfileName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        tvProfileName.setText("12 Day");
        tvProfileName.setPadding(0, 0, 15, 0);
        tvProfileName.setTextColor(Color.DKGRAY);

        TextView tvsubText = new TextView(mContext);
        tvsubText.setTypeface(Typeface.DEFAULT_BOLD);
        tvsubText.setText("User Interface Designer");
        tvsubText.setGravity(Gravity.CENTER);
        tvsubText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//        tvsubText.setPadding(0, 0, 15, 0);
        tvsubText.setTextColor(Color.LTGRAY);


        linearLayout.addView(imageRounded);
        linearLayout.addView(tvProfileName);
        linearLayout.addView(tvsubText);
        shadowRectLayout.addView(linearLayout);

        ProfileGridAdapter.CardData cardData = new ProfileGridAdapter.CardData(shadowRectLayout);
        return cardData;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileGridAdapter.CardData cardData, int i) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    class CardData extends RecyclerView.ViewHolder {
        public CardData(@NonNull View itemView) {
            super(itemView);
        }
    }

}
