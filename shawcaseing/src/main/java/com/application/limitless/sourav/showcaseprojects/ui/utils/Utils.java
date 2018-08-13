package com.application.limitless.sourav.showcaseprojects.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.DisplayMetrics;

import com.application.limitless.sourav.showcaseprojects.R;


public class Utils {
 
// The public static function which can be called from other classes
public static void darkenStatusBar(Activity activity, int color) {
 
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
 
            activity.getWindow().setStatusBarColor(
                    darkenColor(
                            ContextCompat.getColor(activity, color)));
       }
 
    }
 
 
   // Code to darken the color supplied (mostly color of toolbar)
    private static int darkenColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) (dp * metrics.density);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /*public static Drawable drawbg(Context mContext) {
        float radius = 100.0f;

        float[] m_arrfTopHalfOuterRadii =
                new float[]{radius, radius, radius, radius, 0, 0, 0, 0};
        float[] m_arrfBottomHalfOuterRadii =
                new float[]{0, 0, 0, 0, radius, radius, radius, radius};

        int m_nTopColor = 0x65FF6309;
        int m_nBottomColor = 0x65aa6309;

        int m_nCellHeight = 150;

        Drawable drawable=mContext.getResources().getDrawable(R.drawable.metting_img);
        Bitmap bitmap= BitmapFactory.decodeResource(mContext.getResources(),R.drawable.metting_img);


        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), bitmap);
        final float roundPx = (float) bitmap.getWidth() * radius;
        roundedBitmapDrawable.setCornerRadius(roundPx);

        Drawable imageDrawable=roundedBitmapDrawable;

        RoundRectShape top_round_rect =
                new RoundRectShape(m_arrfTopHalfOuterRadii, null, null);
        ShapeDrawable top_shape_drawable = new ShapeDrawable(top_round_rect);
        top_shape_drawable.getPaint().setColor(m_nTopColor);

        RoundRectShape bottom_round_rect =
                new RoundRectShape(m_arrfBottomHalfOuterRadii, null, null);
        ShapeDrawable bottom_shape_drawable = new ShapeDrawable(bottom_round_rect);
        bottom_shape_drawable.getPaint().setColor(m_nBottomColor);

        Drawable[] drawarray = {imageDrawable,top_shape_drawable, bottom_shape_drawable};
        LayerDrawable layerdrawable = new LayerDrawable(drawarray);

        int _nHalfOfCellHeight = m_nCellHeight / 2;
        layerdrawable.setLayerInset(0, 0, 0, 0, 0); //top half
        layerdrawable.setLayerInset(1, 0, 0, 0, _nHalfOfCellHeight); //top half
        layerdrawable.setLayerInset(2, 0, _nHalfOfCellHeight, 0, 0); //bottom half

        return layerdrawable;
    }
*/



    /*public static Drawable getGradiantDrawable(Context mContext,float fRadius,int color1,int color2 ) {
        float radius = fRadius;

        float[] m_arrfTopHalfOuterRadii =
                new float[]{radius, radius, radius, radius, 0, 0, 0, 0};

//        int m_nCellHeight = 150;

        Bitmap bitmap= BitmapFactory.decodeResource(mContext.getResources(),R.drawable.metting_img);
//        bitmap.setHeight(100);
//        bitmap.setWidth(200);



        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), bitmap);
        final float roundPx = (float) bitmap.getWidth() * radius;
        roundedBitmapDrawable.setCornerRadius(radius);

        Drawable imageDrawable=roundedBitmapDrawable;


        GradientDrawable roundGradiantDrawable = new GradientDrawable();
//        gradientDrawable.setOrientation(GradientDrawable.Orientation.BL_TR);
        roundGradiantDrawable.setShape(GradientDrawable.LINEAR_GRADIENT);
        roundGradiantDrawable.setCornerRadii(new float[]{radius, radius, radius, radius, radius, radius,radius,radius});
        roundGradiantDrawable.setColors(new int[]{color1, color2});


        Drawable[] drawarray = {imageDrawable, roundGradiantDrawable};
        LayerDrawable layerdrawable = new LayerDrawable(drawarray);

//        int _nHalfOfCellHeight = m_nCellHeight / 2;
        layerdrawable.setLayerInset(0, 0, 0, 0, 0); //top half
        layerdrawable.setLayerInset(1, 0, 0, 0, 0); //top half
//        layerdrawable.setLayerInset(2, 0, _nHalfOfCellHeight, 0, 0); //bottom half

        return layerdrawable;
    }*/
}