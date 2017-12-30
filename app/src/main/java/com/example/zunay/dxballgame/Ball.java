package com.example.zunay.dxballgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Zunayed on 12/28/2017.
 */

public class Ball extends Drawable{
    private float radius;
    Canvas canvas;
    Paint paint=new Paint();
    public Ball()
    {

    }
    public Ball(float x,float y,float radius, Canvas canvas,Paint paint)
    {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.canvas=canvas;
        this.paint=paint;
    }

    @Override
    public void paint(Canvas canvas, Paint paint) {
        super.paint(canvas, paint);
        canvas.drawCircle(x,y,radius,paint);
    }

    private void invalidate() {
    }
}
