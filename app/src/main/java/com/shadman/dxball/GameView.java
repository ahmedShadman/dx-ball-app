package com.shadman.dxball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Shadman on 11/18/2015.
 */
public class GameView extends View {
    Paint paint;
    float x=0,y=0, radius=0;
    boolean firstTime=true;

    public GameView(Context context) {
        super(context);
        paint = new Paint();
    }

    public void calculateNextPos() {
        y++;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (firstTime) {
            firstTime = false;
            x=canvas.getWidth()/2;
            y=canvas.getHeight()/2;
        }
        calculateNextPos();
        canvas.drawRGB(255, 255, 255);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y,40,paint);
        //canvas.drawRect(100, 100, 200, 200, paint);
        invalidate();
    }
}
