package com.example.zunay.dxballgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Zunayed on 12/28/2017.
 */

public interface IDrawable {
    void paint(Canvas canvas, Paint paint);
    void collide();
}
