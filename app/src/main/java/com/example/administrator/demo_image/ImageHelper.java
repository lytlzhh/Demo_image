package com.example.administrator.demo_image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2017/1/10/010.
 */

public class ImageHelper {
    /*四个参数：图片，色相，饱和度，亮度*/
    public static Bitmap imagehandler(Bitmap bitmap, float hue, float saturation, float lum) {
    /*注意：参数中的bitmap默认不可修改的*/
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        /*不可再原图上操作，需要创建画布，画笔*/
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);/*抗锯齿待研究*/

        /*????*/
        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);


        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);



        /*融合以上三个属性*/
        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        /*赋予画笔属性*/
        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        /*将画布绘制出来*/
        canvas.drawBitmap(bitmap, 0, 0, paint);

        return bitmap1;
    }
}
