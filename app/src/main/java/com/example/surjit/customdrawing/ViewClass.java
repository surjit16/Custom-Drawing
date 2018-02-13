package com.example.surjit.customdrawing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by surjit on 01-02-2018.
 */

public class ViewClass extends SurfaceView {

    private Context context;
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;

    private Bitmap bitmap;

    public ViewClass(Context context) {
        super(context);
        this.context = context;
        surfaceHolder = getHolder();

        bitmap = new BitmapFactory().decodeResource(getResources(), R.drawable.brown);

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas canvas = surfaceHolder.lockCanvas();
                onDraw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });


    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(100f);
        canvas.drawText("Hi Ji Ki Hal Ha", 100,100 ,p);
        p.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth()/2-100, getHeight()/2-100, 50, p);

        Rect rect = new Rect(500,500,800,800);
        canvas.drawRect(rect, p);

        canvas.drawBitmap(bitmap, 200, 100, null);
    }
}
