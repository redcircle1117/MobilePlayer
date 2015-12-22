package com.hong.mobileplayer;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

/**
 * Created by Hong on 2015/12/22.
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;

    private int[] ids = {R.drawable.video,
            R.drawable.music,
            R.drawable.network,
            R.drawable.all,
            R.drawable.live,
            R.drawable.advert};
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏左边按钮
        setLeftButton(View.GONE);
        //设置标题
        //setTitle("321影音");

        gridView = (GridView) findViewById(R.id.gridView);

        //设置适配器adapter
        adapter = new MainAdapter();
        gridView.setAdapter(adapter);

        //设置GridView的item的点击按钮

        gridView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, VideoListActivity.class));
                finish();
                break;
            case 1:
                Toast.makeText(this, "音乐播放", Toast.LENGTH_SHORT).show();
                break;

           default:
               Toast.makeText(this, "暂未启用", Toast.LENGTH_SHORT).show();
               break;
        }
    }


    /**
     * 加载本地布局
     * @return
     */
    @Override
    public View getChildView() {
        return View.inflate(this, R.layout.activity_main, null);
    }

    @Override
    protected void clickLeftButton() {

    }

    @Override
    protected void clickRightButton() {

    }


    class MainAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return ids.length;
        }

        @Override
        public Object getItem(int position) {
            return ids[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainActivity.this, R.layout.item_main, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_main_icon);
            imageView.setImageResource(ids[position]);
            return view;
        }
    }

}

