package com.application.limitless.sourav.showcaseprojects.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.limitless.sourav.showcaseprojects.R;
import com.application.limitless.sourav.showcaseprojects.ui.base.component.ShadowRectLayout;
import com.application.limitless.sourav.showcaseprojects.ui.utils.STextView;
import com.application.limitless.sourav.showcaseprojects.ui.utils.Utils;

public class LoginActivity extends SBaseActivity {
    private int i10dp;
    private int i20dp;
    private int i40dp;
    private int i3dp;
    private int i5dp;
    private int i15dp;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Utils.setLightStatusBar(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setPadding(0, Utils.dpToPixel(25), 0, 0);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.about_background));
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView ivCompLogo = new ImageView(this);
        ivCompLogo.setLayoutParams(new LinearLayout.LayoutParams(Utils.getScreenWidth(), Utils.getScreenWidth() / 3));
        ivCompLogo.setImageResource(R.drawable.workwave_logo);
        ivCompLogo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        STextView tvCompName = new STextView(this);
        tvCompName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        tvCompName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvCompName.setGravity(Gravity.CENTER);
        tvCompName.setText("W o r k w a v e");
        tvCompName.setShadowLayer(10, 5.0f, 5.0f, Color.GRAY);
        tvCompName.setTypeface(Typeface.DEFAULT_BOLD);
        tvCompName.setTextColor(Color.BLACK);

        TextView tvError = new TextView(this);
        tvError.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        tvError.setVisibility(View.INVISIBLE);
        tvError.setId(R.id.tv_loginError);
        tvError.setGravity(Gravity.CENTER);
        tvError.setText("Invalid Email / Password");
        tvError.setTextColor(getResources().getColor(android.R.color.holo_red_light));

        STextView tvAccount = new STextView(this);
        tvAccount.setText("Don't have an Account ?");
        tvAccount.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvAccount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        tvAccount.setTextColor(Color.GRAY);

        STextView tvSingUpPage = new STextView(this);
        tvSingUpPage.setText("Sign Up Now");
        tvSingUpPage.setId(R.id.singup_layout);
        tvSingUpPage.setAllCaps(true);
        tvSingUpPage.setPaintFlags(tvSingUpPage.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvSingUpPage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvSingUpPage.setTypeface(Typeface.DEFAULT_BOLD);
        tvSingUpPage.setOnClickListener(new DialogEventClickListener());
        tvSingUpPage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tvSingUpPage.setTextColor(Utils.getColorStateListDrawable(getResources().getColor(R.color.blue_login1), getResources().getColor(R.color.blue_login2)));


        linearLayout.addView(ivCompLogo);
        linearLayout.addView(tvCompName);
        linearLayout.addView(getGapView(30));
        linearLayout.addView(getShadowEditFields(R.drawable.ic_user_symbol, "Username", R.id.user_name));
        linearLayout.addView(getGapView(15));
        linearLayout.addView(getShadowEditFields(R.drawable.ic_locked_padlock, "Password", R.id.user_password));
        linearLayout.addView(tvError);
        linearLayout.addView(getGapView(20));
        linearLayout.addView(getSignInButton());
        linearLayout.addView(getGapView(25));
        linearLayout.addView(tvAccount);
        linearLayout.addView(tvSingUpPage);


        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scrollView.setFillViewport(true);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }

    public ShadowRectLayout getShadowEditFields(@DrawableRes int iconEditText, String hintEditText, int edittextId)
    {

        i3dp = Utils.dpToPixel(3);
        i5dp = Utils.dpToPixel(5);
        i10dp = Utils.dpToPixel(10);
        i15dp = Utils.dpToPixel(15);
        i20dp = Utils.dpToPixel(20);
        i40dp = Utils.dpToPixel(40);
        ShadowRectLayout shadowRectLayout = new ShadowRectLayout(this);
        shadowRectLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        shadowRectLayout.setOffSetX(0);
        shadowRectLayout.setOffSetY(19);
        shadowRectLayout.setRoundCornerRadius(Utils.dpToPixel(50));
        shadowRectLayout.setShadowRadius(20);
        shadowRectLayout.setShadowColor(getResources().getColor(R.color.gray_300));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setPadding(i10dp, i5dp, i5dp, i5dp);

        ImageView ivEditIcon = new ImageView(this);
        ivEditIcon.setLayoutParams(new LinearLayout.LayoutParams(Utils.dpToPixel(24), Utils.dpToPixel(24)));
        ivEditIcon.setImageResource(iconEditText);

        EditText etEditFields = new EditText(this);
        etEditFields.setLayoutParams(new LinearLayout.LayoutParams(Utils.getScreenWidth() / 2, ViewGroup.LayoutParams.WRAP_CONTENT));
        etEditFields.setHint(hintEditText);
        etEditFields.setId(edittextId);
        etEditFields.setMaxLines(1);
        etEditFields.setTextSize(14);
        etEditFields.setSingleLine(true);
        etEditFields.setHintTextColor(getResources().getColor(R.color.gray_medium));
        etEditFields.setBackground(null);
        if (edittextId == R.id.user_password)
            etEditFields.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        else
            etEditFields.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        linearLayout.addView(ivEditIcon);
        linearLayout.addView(etEditFields);
        shadowRectLayout.addView(linearLayout);
        return shadowRectLayout;
    }

    public View getGapView(int iHeight)
    {
        View gapView = new View(this);
        gapView.setLayoutParams(new LinearLayout.LayoutParams(0, Utils.dpToPixel(iHeight)));
        return gapView;
    }

    public ShadowRectLayout getSignInButton()
    {
        ShadowRectLayout shadowRectLayout = new ShadowRectLayout(this);
        shadowRectLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        shadowRectLayout.setOffSetY(0);
        shadowRectLayout.setOffSetX(0);
        shadowRectLayout.setShadowRadius(0);
        shadowRectLayout.setShadowLeft(false);
        shadowRectLayout.setShadowRight(false);
        shadowRectLayout.setShadowTop(false);
        shadowRectLayout.setShadowBottom(false);
        //        shadowRectLayout.setShadowColor(getResources().getColor(R.color.blue_login1));
        shadowRectLayout.setImgGradientColor1(getResources().getColor(R.color.blue_login1));
        shadowRectLayout.setImgGradientColor2(getResources().getColor(R.color.blue_login2));
        shadowRectLayout.setId(R.id.singin_layout);
        shadowRectLayout.setOnClickListener(new DialogEventClickListener());
        shadowRectLayout.setRoundCornerRadius(i40dp);
        STextView textView = new STextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(Utils.getScreenWidth() / 2 + Utils.dpToPixel(40), ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText("Sing In");
        textView.setAllCaps(true);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        textView.setTextColor(Utils.getColorStateListDrawable(Color.WHITE, getResources().getColor(R.color.pure_black)));
        textView.setPadding(0, i10dp, 0, i10dp);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        shadowRectLayout.addView(textView);
        return shadowRectLayout;
    }

    private class DialogEventClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view)
        {
            if (view.getId() == R.id.singin_layout)
            {

                final TextView textView = findViewById(R.id.tv_loginError);
                textView.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                        textView.setVisibility(View.INVISIBLE);
                    }
                }, 1500);


            } else if (view.getId() == R.id.singup_layout)
            {

                Toast.makeText(LoginActivity.this, "Todo", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
