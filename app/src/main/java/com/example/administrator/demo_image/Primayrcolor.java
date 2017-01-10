package com.example.administrator.demo_image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2017/1/10/010.
 */

public class Primayrcolor extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView imageView;
    private SeekBar seekBar_hue, seekBar_saturation, seekBar_lum;

    /*设置颜色的最大值和中间值*/
    private static int MAX_VALUE = 255;
    private static int MID_VALE = 127;

    /*将色调，饱和度，亮度传给帮助类*/
    private float mhue, msaturation, mlum;


    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primarycolor);
        init_ID();

    }

    public void init_ID() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        imageView = (ImageView) findViewById(R.id.imageview_id);
        imageView.setImageBitmap(bitmap);


        seekBar_hue = (SeekBar) findViewById(R.id.seekbar_hue);
        seekBar_saturation = (SeekBar) findViewById(R.id.seekbar_saturation);
        seekBar_lum = (SeekBar) findViewById(R.id.seekbar_lum);

        seekBar_hue.setOnSeekBarChangeListener(this);
        seekBar_saturation.setOnSeekBarChangeListener(this);
        seekBar_lum.setOnSeekBarChangeListener(this);

        /*设置颜色的最大值*/
        seekBar_hue.setMax(MAX_VALUE);
        seekBar_saturation.setMax(MAX_VALUE);
        seekBar_lum.setMax(MAX_VALUE);

        /*设置颜色的中间值*/
        seekBar_hue.setProgress(MID_VALE);
        seekBar_saturation.setProgress(MID_VALE);
        seekBar_lum.setProgress(MID_VALE);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_hue:
                /*????????????????????*/
                mhue = (progress - MID_VALE) * 1.0F / MID_VALE * 180;
                break;
            case R.id.seekbar_saturation:
                msaturation = progress * 1.0F / MID_VALE;
                break;
            case R.id.seekbar_lum:
                mlum = progress * 1.0F / MID_VALE;

                break;
        }

        imageView.setImageBitmap(ImageHelper.imagehandler(bitmap, mhue, msaturation, mlum));  //ImageHelper.imagehandler(bitmap, mhue, msaturation, mlum);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
