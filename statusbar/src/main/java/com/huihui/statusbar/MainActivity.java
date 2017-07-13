package com.huihui.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.huihui.statusbar.R.id.toolbar;


public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) findViewById(toolbar);
        mToolbar.setTitle("动脑学院");
        setSupportActionBar(mToolbar);
        View nav = findViewById(R.id.nav);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            getWindow().setStatusBarColor(Color.GREEN);
           getWindow().setNavigationBarColor(Color.GREEN);

        }else {

            setToolBarStyle(mToolbar, nav, Color.YELLOW);
        }


    }
}
