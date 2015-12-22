package com.hong.mobileplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //在欢迎界面停留两秒进入主界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //当前实在主线程中
                Log.e(TAG, Thread.currentThread().getName()+"=======");
                startMainActivity();//前往MainActivity
            }
        }, 2000);
    }

    boolean inMainActivity;
    /**
     * 前往MainActivity界面
     */
    private void startMainActivity() {
        if (!inMainActivity) {
            inMainActivity = true;
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMainActivity();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        inMainActivity = false;
    }
}
