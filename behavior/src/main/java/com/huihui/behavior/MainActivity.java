package com.huihui.behavior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = ((RecyclerView) findViewById(R.id.recyclverView));


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<String> datas = new ArrayList<>();


        for (int i = 0; i < 40; i++) {

            datas.add("裴银辉：" + i);
        }
        mRecyclerView.setAdapter(new MyAdapter(datas));
    }
}
