package com.example.zunay.dxballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Zunayed on 12/28/2017.
 */

public class GameCanvas extends View {
    Context context;
    Paint paint;
    Canvas canvas;
    Stage stageObj;
    boolean firstTime = true;
    private static int counter = 0;
    String level;


    protected void onDraw(Canvas canvas) {
        if (firstTime) {
            firstTime = false;
            level=Level.current_level;
            stageObj = new Stage(context, canvas, paint,level);
        }
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(75);
        canvas.drawText(level, 60, 100, paint);
        canvas.drawText("Life :"+DXBallActivity.life, 400, 100, paint);
        stageObj.drawStage(canvas, paint);

        invalidate();
    }

    public class touchHandler implements OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {

                case MotionEvent.ACTION_MOVE:
                    Stage.leftBar = motionEvent.getX();
                    Stage.rightBar = Stage.leftBar + 300;
                    counter++;
                    break;
                case MotionEvent.ACTION_UP:
                    if (counter < 10) {
                        if (Stage.isPause) {
                            Stage.isPause = false;
                        }
                        if (!Stage.isPause) {
                            Stage.isPause = false;
                        }
                    }
                    counter = 0;
                    break;
            }
            return true;
        }
    }

    public GameCanvas(Context context, String str) {
        super(context);
        this.level=str;
        paint = new Paint();
        this.context = context;
        this.setOnTouchListener(new touchHandler());

    }

}
