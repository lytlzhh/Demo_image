package com.example.administrator.demo_image;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView xiaomu_image;
    private Button primary_image;
    private Button primary_image1;
    private Button primary_image2;
    private LinearLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        xiaomu_image = (TextView) findViewById(R.id.xiaomu_image);
        primary_image = (Button) findViewById(R.id.primary_image);
        primary_image1 = (Button) findViewById(R.id.primary_image1);
        primary_image2 = (Button) findViewById(R.id.primary_image2);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);

        primary_image.setOnClickListener(this);
        primary_image1.setOnClickListener(this);
        primary_image2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.primary_image:
                startActivity(new Intent(this, Primayrcolor.class));
                break;
            case R.id.primary_image1:

                break;
            case R.id.primary_image2:

                break;
        }
    }
}
