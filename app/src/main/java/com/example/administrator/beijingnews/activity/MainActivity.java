package com.example.administrator.beijingnews.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.administrator.beijingnews.R;
import com.example.administrator.beijingnews.fragment.AIServiceFragment;
import com.example.administrator.beijingnews.fragment.GovFragment;
import com.example.administrator.beijingnews.fragment.HomeFragment;
import com.example.administrator.beijingnews.fragment.NewsFragment;
import com.example.administrator.beijingnews.fragment.SettingFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    //不能实现左右滑动功能，因为还要呼出左侧菜单！！！

    @ViewInject(R.id.main_viewpager)
    private ViewPager viewPager;

    private MainFragmentAdapter mainFragmentAdapter;

    private FragmentManager fm;

    private List<Fragment> data = null;

    @ViewInject(R.id.main_radiogroup)
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        initFragment();
        mainFragmentAdapter = new MainFragmentAdapter(fm);
        viewPager.setAdapter(mainFragmentAdapter);

        viewPager.setCurrentItem(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_content_fragment_home:
                        viewPager.setCurrentItem(0);

                        break;
                    case R.id.rb_content_fragment_newcenter:
                        viewPager.setCurrentItem(1);

                        break;
                    case R.id.rb_content_fragment_smartservice:
                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.rb_content_fragment_govaffairs:
                        viewPager.setCurrentItem(3);

                        break;
                    case R.id.rb_content_fragment_setting:
                        viewPager.setCurrentItem(4);

                        break;
                }
            }
        });

    }


    private void initFragment() {
        fm = getSupportFragmentManager();
        data = new ArrayList<>();
        AIServiceFragment aiServiceFragment = new AIServiceFragment();
        GovFragment govFragment = new GovFragment();
        NewsFragment newsFragment = new NewsFragment();
        HomeFragment homeFragment = new HomeFragment();
        SettingFragment settingFragment = new SettingFragment();
        //注意添加的顺序
        data.add(homeFragment);
        data.add(newsFragment);
        data.add(aiServiceFragment);
        data.add(govFragment);
        data.add(settingFragment);
//        fm.putFragment(null, "2", aiServiceFragment);
//        fm.putFragment(null, "3", govFragment);
//        fm.putFragment(null, "1", newsFragment);
//        fm.putFragment(null, "0", homeFragment);
//        fm.putFragment(null, "4", settingFragment);
        // fm.putFragment(null,);
    }

//    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//
//
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }

    class MainFragmentAdapter extends FragmentPagerAdapter {


        public MainFragmentAdapter(FragmentManager fm) {
            super(fm);

        }


        @Override
        public Fragment getItem(int position) {
//返回对应未知的Fragment

            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }
}
