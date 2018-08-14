package com.application.limitless.sourav.showcaseprojects.modle.dto;

import android.graphics.Color;

public class CardDataDto {

    private final int iColor1;
    private final int iColor2;

    public CardDataDto(int iColor2)
    {
        this.iColor2 = iColor2;
        this.iColor1 = getDarkerColor(iColor2);


    }

    public int getiColor1()
    {
        return iColor1;
    }


    public int getiColor2()
    {
        return iColor2;
    }




    public int getDarkerColor(int color)
    {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[1] = hsv[1] + 0.1f;
        hsv[2] = hsv[2] - 0.1f;
        int darkerColor = Color.HSVToColor(hsv);
        return darkerColor;
    }
}
