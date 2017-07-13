package com.huihui.palette;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);


        Palette.from(BitmapFactory.decodeResource(getResources(), R.drawable.a)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {


                List<Palette.Swatch> swatches = palette.getSwatches();

                Log.e(TAG, "===============swatches size======" + swatches.size());

                for (Palette.Swatch swatch : swatches) {


                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                    View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_content, null);

                    Log.e(TAG, "=====================111");


                    if (swatch != null) {
                        Log.e(TAG, "=====================222222");

                        View rgb = view.findViewById(R.id.rgb);
                        View body = view.findViewById(R.id.body);
                        View title = view.findViewById(R.id.title);

                        rgb.setBackgroundColor(swatch.getRgb());

                        body.setBackgroundColor(swatch.getBodyTextColor());
                        title.setBackgroundColor(swatch.getTitleTextColor());


                        linearLayout.addView(view, params);

                    }


                }


                Palette.Swatch lightVibrantSwatch = palette.getDarkVibrantSwatch();


                if (lightVibrantSwatch == null) {

                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        if (null != swatch) {
                            lightVibrantSwatch = swatch;
                            break;
                        }
                    }
                }


                //起始颜色
                /**
                 * 每次加深0.1
                 *
                 */
                int color = lightVibrantSwatch.getRgb();
                for (int i = 0; i < 9; i++) {
                    TextView textView = new TextView(MainActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(10, 10, 0, 0);
                    int r = Color.red(color);
                    int g = Color.blue(color);
                    int b = Color.green(color);
                    textView.setText("颜色  r " + r + "  b  " + b + "  g  " + g);
                    textView.setBackgroundColor(color);
                    textView.setHeight(100);
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    //加深一次  0.1
                    color = colorBurn(color);
                    linearLayout.addView(textView, layoutParams);
                }


            }
        });
    }


    public void onAn(View view) {

        startActivity(new Intent(MainActivity.this, BankActivity.class));
    }


    private int colorBurn(int rgb) {
        //加深颜色
        //        int all= (int) (rgb*1.1f);
        //        红色
        int red = rgb >> 16 & 0xFF;
        int gree = rgb >> 8 & 0xFF;
        int blue = rgb & 0xFF;

        //
        red = (int) Math.floor(red * (1 - 0.1));
        gree = (int) Math.floor(gree * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, gree, blue);

    }
}
