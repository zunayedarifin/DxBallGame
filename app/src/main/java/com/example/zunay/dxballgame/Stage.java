package com.example.zunay.dxballgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zunayed on 12/28/2017.
 */

public class Stage {
    Context context;
    private Canvas canvas;
    private float dx,dy,radius,x_ball,y_ball,canvasWidth,canvasHeight;
    private float x_points=760;
    private float y_points=100;
    private String level="";
    private int numberOfBricks;
    static int points;
    private Paint paint;
    static float leftBar, rightBar, topBar, bottomBar;
    private List<Brick> listBrick;
    static boolean isPause;
    private Ball ball;

    private void win() {
        if (points==numberOfBricks)
        {
            Intent intent= new Intent(context,LoseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
    private void updateBallPosition() {
        if(x_ball<=radius || x_ball>=canvas.getWidth()-radius)
        {
            dx=-dx;
        }
        if (y_ball<=radius)
        {
            dy=-dy;
        }
        x_ball-=dx;
        y_ball-=dy;
    }
    private void updatePoints(Canvas canvas, Paint paint) {
        paint.setTextSize(50);
        canvas.drawText("Points :"+points,x_points,y_points,paint);
    }
    public void createBricks() {
        Brick bricks;
        float x_brick=100,y_brick=160;
        for(int i=0;i<numberOfBricks;i++)
        {
            if (x_brick + 260 > canvas.getWidth()) {
                x_brick = 100;
                y_brick += 120;
            }
            bricks = new Brick(x_brick, y_brick, x_brick + 200, y_brick + 100, canvas, paint);
            listBrick.add(bricks);
            x_brick += 220;
        }
    }
    public void colides() {
        List<Brick> toRemove = new ArrayList<>();
        for (Brick obj : listBrick) {
            if ((y_ball+radius) - obj.getBottom() < 8 &&
                    Math.abs(obj.getBottom() - (y_ball+radius)) < 8 &&
                    x_ball+radius >= obj.getLeft() &&
                    x_ball+radius <= obj.getRight()) {
                dy = -dy;
                toRemove.add(obj);
                points+=1;
            }
        }
        if (x_ball>= leftBar && x_ball<= rightBar && topBar - (y_ball+radius) < 5) {
            dy = -dy;

        }
        listBrick.removeAll(toRemove);

    }
    public Stage(Context context, Canvas canvas, Paint paint, String string) {
        this.level=string;
        String line="";
        StringBuilder finalString = new StringBuilder();
        InputStream inputStream;
        if(Level.current_level=="Level 1"){
            inputStream = context.getResources().openRawResource(R.raw.level_1);
        }else if(Level.current_level=="Level 2"){
            inputStream = context.getResources().openRawResource(R.raw.level_2);
        }else if(Level.current_level=="Level 3"){
            inputStream = context.getResources().openRawResource(R.raw.level_3);
        }else if(Level.current_level=="Level 4"){
            inputStream = context.getResources().openRawResource(R.raw.level_4);
        }else if(Level.current_level=="Level 5"){
            inputStream = context.getResources().openRawResource(R.raw.level_5);
        }else if(Level.current_level=="Level 6"){
            inputStream = context.getResources().openRawResource(R.raw.level_6);
        }else if(Level.current_level=="Level 7"){
            inputStream = context.getResources().openRawResource(R.raw.level_7);
        }else if(Level.current_level=="Level 8"){
            inputStream = context.getResources().openRawResource(R.raw.level_8);
        }else{
            inputStream = context.getResources().openRawResource(R.raw.level_9);
        }

        BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
        try{
            while ((line= reader.readLine()) !=null){
                finalString.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String brick=finalString.substring(finalString.indexOf("=")+1,finalString.indexOf(" "));
        String speed = finalString.substring(finalString.indexOf("Speed=")+6);
        speed= speed.trim();
        brick = brick.trim();
        this.context = context;
        this.canvas = canvas;
        this.paint = paint;
        radius = 40;
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        leftBar = (canvas.getWidth() / 2) - 150;
        rightBar = leftBar + 300;
        topBar = canvas.getHeight() - 100;
        bottomBar = canvas.getHeight() - 50;
        x_ball = leftBar+120;
        y_ball = topBar-radius+5;
        points = 0;
        numberOfBricks = Integer.valueOf(brick);
        dx=dy=Integer.valueOf(speed);
        isPause = true;
        listBrick = new ArrayList<>();
        createBricks();
    }
    public void drawStage(Canvas canvas,Paint paint) {

        int myColor = context.getResources().getColor(R.color.Red);
        paint.setColor(myColor);
        ball = new Ball(x_ball, y_ball,radius, canvas, paint);
        ball.paint(canvas, paint);

        myColor = context.getResources().getColor(R.color.Black);
        paint.setColor(myColor);
        Bar bar = new Bar(leftBar, topBar, rightBar, bottomBar, canvas, paint);
        bar.paint(canvas, paint);
        myColor = context.getResources().getColor(R.color.Green);
        paint.setColor(myColor);
        for (Brick obj : listBrick) {
            obj.paint(canvas, paint);
        }
        if(!isPause){
            updateBallPosition();
        }else {
            dx= Math.abs(dx);
            dy = Math.abs(dy);
        }
        colides();
        updatePoints(canvas, paint);
        win();
        remaingLife(context);
    }
    private void remaingLife(Context context) {
        if (DXBallActivity.life<=0)
        {
            Intent intent= new Intent(context,LoseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            DXBallActivity.life=1;
        }
        if (y_ball>canvas.getHeight()-40)
        {
            //canvas.drawText("Life", 400, 100, paint);
            DXBallActivity.life -=1;
            x_ball=leftBar+120;
            y_ball=topBar-radius+5;
            isPause=true;
        }
    }
}
