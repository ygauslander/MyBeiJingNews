package com.example.administrator.beijingnews.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.beijingnews.R;
import com.example.administrator.beijingnews.adapter.GuidePageAdapter;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {

    private List<ImageView> data;

    private GuidePageAdapter adapter;

    @ViewInject(value = R.id.viewpage)
    private ViewPager viewPager;

    @ViewInject(value = R.id.ll_point_group)
    private LinearLayout ll_point_group;

    @ViewInject(value = R.id.btn_start_main)
    private Button btn_start_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        x.view().inject(this);
        initData();
        adapter = new GuidePageAdapter(this, data);
        viewPager.setAdapter(adapter);


    }

    private void initData() {
        int arr[] = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
        data = new ArrayList<>();
        ImageView imageView;
        for (int i = 0; i < arr.length; i++) {
            imageView = new ImageView(this);
            imageView.setBackgroundResource(arr[i]);
            data.add(imageView);
        }

    }
}
