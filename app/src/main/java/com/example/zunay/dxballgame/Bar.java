package com.example.zunay.dxballgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Zunayed on 12/28/2017.
 */

public class Bar extends Drawable {
    private float left, top, right, bottom;
    Canvas canvas; Paint paint;


    public Bar()
    {

    }
    public Bar (float left, float top, float right, float bottom, Canvas canvas, Paint paint)
    {
        this.left = left;
        this.top = top;
        this.bottom = bottom;
        this.right = right;
        this.canvas = canvas;
        this.paint = paint;
    }

    @Override
    public void paint(Canvas canvas, Paint paint) {
        super.paint(canvas, paint);
        canvas.drawRect(left, top, right, bottom, paint);
    }
}
