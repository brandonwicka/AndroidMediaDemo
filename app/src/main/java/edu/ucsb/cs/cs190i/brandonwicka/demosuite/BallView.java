package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Random;

/**
 * Created by brand_000 on 2/11/2016.
 */
public class BallView extends View {


    int Px = -1, Py = -1;
    int ballDiameter = 50;
    int Vx, Vy;

    public BallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.YELLOW);

        Random r = new Random();
        int speed = r.nextInt(81 - 1) + 1;
        Vx = speed;
        Vy = speed;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint red = new Paint();
        red.setARGB(255, 255, 0, 0);

        int w = this.getWidth();
        int h = this.getHeight();

        if(Px < 0 && Py < 0) {
            Px = w / 2;
            Py = h / 2;
        }


        if((Px + ballDiameter) > w )  {
            Vx = -Vx;
        }
        if((Py + ballDiameter) > h) {
            Vy = -Vy;
        }
        if((Px - ballDiameter) < 0) {
            Vx = -Vx;
        }
        if((Py - ballDiameter) < 0) {
            Vy = -Vy;
        }

        Px += Vx;
        Py += Vy;

        canvas.drawCircle(Px, Py, ballDiameter, red);
    }


    public int getSpeed() {

        return Vx;
    }

    public void setSpeed(int n) {
        Vx = n;
        Vy = n;
    }


}
