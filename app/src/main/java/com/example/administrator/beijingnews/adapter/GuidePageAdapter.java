package com.example.administrator.beijingnews.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class GuidePageAdapter extends PagerAdapter {

    private Context context;

    private List<ImageView> data;

    public GuidePageAdapter(Context context, List<ImageView> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = data.get(position);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        // super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
