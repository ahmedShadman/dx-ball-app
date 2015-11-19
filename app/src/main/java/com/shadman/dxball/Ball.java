package com.shadman.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Shadman on 11/19/2015.
 */
public class Ball {
    private float x,y,radius=30;

    public void setBall(Canvas canvas,Bar bar) {
        float barMid = (bar.getBarRight()-bar.getBarLeft())/2;
        x = bar.getBarLeft()+barMid;
        y = bar.getBarTop()-radius;
    }

    public void drawBall(Canvas canvas, Paint paint){
        canvas.drawCircle(x,y,radius,paint);
    }
}
