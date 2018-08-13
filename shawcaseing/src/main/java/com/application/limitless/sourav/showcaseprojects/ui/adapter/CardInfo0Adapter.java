package com.application.limitless.sourav.showcaseprojects.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.ui.base.component.ShadowRectLayout;
import com.application.limitless.sourav.showcaseprojects.ui.utils.Utils;


public class CardInfo0Adapter extends RecyclerView.Adapter<CardInfo0Adapter.CardData> {
    final Context mContext;

    public CardInfo0Adapter(Activity mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CardInfo0Adapter.CardData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        int radii = Utils.dpToPixel(15);
//        int radii = 4;
        ShadowRectLayout shadowRectLayout = new ShadowRectLayout(mContext);
//        shadowRectLayout.setClipToPadding(false);
//        shadowRectLayout.setClipToOutline(false);
//        shadowRectLayout.setClipChildren(false);
        shadowRectLayout.setOffSetY(5);
        shadowRectLayout.setImgGradientColor1(0xD89A5FE2);
        shadowRectLayout.setImgGradientColor2(0xD6DE39C2);
        shadowRectLayout.setResDrawable(R.drawable.metting_img);
        shadowRectLayout.setShadowRadius(30);
        shadowRectLayout.setRoundCornerRadius(30);
        shadowRectLayout.setShadowColor(0xD6DE39C2);

//        shadowRectLayout.setPreventCornerOverlap(false);

        LinearLayout roundLinearLayout = new LinearLayout(mContext);
        roundLinearLayout.setPadding(Utils.dpToPixel(15), Utils.dpToPixel(25), Utils.dpToPixel(8), Utils.dpToPixel(8));
        roundLinearLayout.setOrientation(LinearLayout.VERTICAL);

        roundLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(Utils.dpToPixel(250),Utils.dpToPixel(140)));

        TextView headLable = new TextView(mContext);
        headLable.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        headLable.setText("Focus Series");
        headLable.setTextColor(mContext.getResources().getColor(R.color.pure_white));
        headLable.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        headLable.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);


        TextView subText = new TextView(mContext);
        subText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        LinearLayout.LayoutParams subTextParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        subTextParam.setMargins(0, Utils.dpToPixel(5), 0, 0);
        subText.setLayoutParams(subTextParam);
        subText.setTextColor(Color.WHITE);
        subText.setText("Tweeter");
        subText.setTextColor(mContext.getResources().getColor(R.color.pure_white));
        subText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        subText.setPadding(Utils.dpToPixel(8), Utils.dpToPixel(3), Utils.dpToPixel(8), Utils.dpToPixel(3));

        GradientDrawable textGradiantDrawable = new GradientDrawable();
        textGradiantDrawable.setCornerRadius(Utils.dpToPixel(25));
        textGradiantDrawable.setColor(0x5EFFFFFF);
        subText.setBackground(textGradiantDrawable);


        roundLinearLayout.addView(headLable);
        roundLinearLayout.addView(subText);
//        roundLinearLayout.setBackground(Utils.getGradiantDrawable(mContext,radii,0xD89A5FE2, 0xD6DE39C2));
        shadowRectLayout.addView(roundLinearLayout);


        return new CardData(shadowRectLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull CardInfo0Adapter.CardData cardData, int i) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class CardData extends RecyclerView.ViewHolder {
        public CardData(@NonNull View itemView) {
            super(itemView);
        }
    }

}