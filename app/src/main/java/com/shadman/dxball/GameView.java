package com.shadman.dxball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Shadman on 11/18/2015.
 */
public class GameView extends View {
    Paint paint;
    Bar bar;
    Ball ball;
    float xT;
    float x=0,y=0, radius=0;
    boolean firstTime=true;

    public GameView(final Context context) {
        super(context);
        paint = new Paint();
        bar = new Bar();
        ball = new Ball();
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(ball.isBallAlive()) {
                    xT = event.getX();
                    if (xT < v.getWidth() / 2 && bar.getBarLeft() > 0) {
                        bar.setBarLeft(bar.getBarLeft()-10);
                        xT=-10;
                    } else if (xT >= v.getWidth() / 2 && bar.getBarRight() < v.getWidth()) {
                        bar.setBarLeft(bar.getBarLeft()+10);
                        xT=-10;
                    }
                }
                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (firstTime) {
            firstTime = false;
            bar.setBar(canvas);
            ball.setBall(canvas, bar);
        }
        canvas.drawRGB(255, 255, 255);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        ball.drawBall(canvas, paint);
        bar.drawBar(canvas, paint);
        ball.nextPos(canvas, bar);
        invalidate();
    }
}
