package com.example.administrator.beijingnews.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.administrator.beijingnews.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class SplashActivity extends Activity {

    @ViewInject(value = R.id.rl_splahs_root)
    private RelativeLayout relativeLayout;  //根布局

    //使用它来判断是否是第一次使用这个应用
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        x.view().inject(this);
        initAnimation();
    }

    private void initAnimation() {

        initShared();
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1500);
        rotateAnimation.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1500);
        alphaAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1500);
        scaleAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(false);//各自使用各自的Interpolator
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new MyAnimationListener());
        relativeLayout.startAnimation(animationSet);


    }

    private void initShared() {
        sharedPreferences = getSharedPreferences("splash_shared", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

            //判断是否是第一次使用,是第一次使用就去引导页，否则直接打开应用主界面
            boolean isFirstTime = sharedPreferences.getBoolean("isFirstTime", true);
            if (isFirstTime) {
                //是第一次使用，去引导页
                editor.putBoolean("isFirstTime", false).commit();
                Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                startActivity(intent);


            } else {
                //不是第一次使用，去主界面
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);


            }
            SplashActivity.this.finish();


        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
