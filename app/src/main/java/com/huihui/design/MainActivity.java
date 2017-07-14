package com.huihui.design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    int lastY;
    int lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setTitle("网易新闻");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("item"+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerAdapter(list));*/


        findViewById(R.id.btn_start).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();

                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        lastY = x;

                        break;

                    case MotionEvent.ACTION_MOVE:


                        int offsetY = y - lastY;

                        view.setY(offsetY);
                        view.invalidate();



                        break;

                    case MotionEvent.ACTION_UP:

                        break;
                }


                return true;
            }
        });


    }
}
