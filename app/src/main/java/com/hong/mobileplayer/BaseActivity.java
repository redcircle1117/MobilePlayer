package com.hong.mobileplayer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.sql.RowSetListener;

public abstract class BaseActivity extends Activity {

    private Button btn_left;
    private Button btn_right;
    private TextView tv_title;
    private LinearLayout ll_child_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setListener();
    }

    private void setListener() {
        btn_left.setOnClickListener(mOnclickListener);
        btn_right.setOnClickListener(mOnclickListener);
    }
    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_left:
                    clickLeftButton();
                    break;

                case R.id.btn_right:
                    clickRightButton();
                    break;
            }
        }
    };

    //加载子布局的抽象方法
    public abstract View getChildView();

    //点击左边按钮的抽象方法
    protected abstract void clickLeftButton();

    //点击右边按钮的抽象方法
    protected abstract void clickRightButton();

    //设置左边按钮的状态
    public void setLeftButton(int visibility) {
        btn_left.setVisibility(visibility);
    }

    //设置右边按钮的状态
    public void setRightButton(int visibility) {
        btn_right.setVisibility(visibility);
    }


    //设置标题
    public void setTitle(String title) {
        tv_title.setText(title);
    }


    private void init() {
        setContentView(R.layout.activity_base);

        btn_left = (Button)findViewById(R.id.btn_left);
        btn_right = (Button)findViewById(R.id.btn_right);
        tv_title = (TextView)findViewById(R.id.tv_title);
        ll_child_content = (LinearLayout)findViewById(R.id.ll_child_content);

        View view = getChildView();
        if (view != null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            ll_child_content.addView(view, params);
        }

    }
}
