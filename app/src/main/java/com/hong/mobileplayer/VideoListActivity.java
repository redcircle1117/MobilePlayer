package com.hong.mobileplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hong.mobileplayer.domain.MediaItem;
import com.hong.mobileplayer.util.Utils;

import java.util.ArrayList;

public class VideoListActivity extends BaseActivity {
    private ListView lv_video;
    private VideoListAdapter adapter;
    private ArrayList<MediaItem> mediaItems;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        utils = new Utils();
        //设置标题
        setTitle("视频列表");

        //设置右边button消失
        setRightButton(View.GONE);

        //获取数据
        getData();

        //设置adapter
        lv_video = (ListView) findViewById(R.id.lv_video);
        adapter = new VideoListAdapter();
        lv_video.setAdapter(adapter);
    }

    private void getData() {

    }

    /**
     * 加载本地布局
     *
     * @return
     */
    @Override
    public View getChildView() {
        return View.inflate(VideoListActivity.this, R.layout.activity_video_list, null);
    }

    /**
     * 返回键返回
     */
    @Override
    protected void clickLeftButton() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void clickRightButton() {
    }


    class VideoListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mediaItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mediaItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.item_video, null);
                holder.tv_video_name = (TextView) convertView.findViewById(R.id.tv_video_item_name);
                holder.tv_video_duration = (TextView) convertView.findViewById(R.id.tv_video_item_duration);
                holder.tv_video_size = (TextView) convertView.findViewById(R.id.tv_video_item_size);
                holder.iv_video_icon = (ImageView) convertView.findViewById(R.id.iv_video_item);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            MediaItem mediaItem = mediaItems.get(position);

            holder.tv_video_name.setText(mediaItem.getTitle());
            holder.tv_video_size.setText(Formatter.formatFileSize(getApplicationContext(),mediaItem.getSize()));
            holder.tv_video_duration.setText(utils.stringForTime((int) mediaItem.getDuration()));

            return convertView;
        }

        class ViewHolder{
            ImageView iv_video_icon;
            TextView tv_video_name;
            TextView tv_video_duration;
            TextView tv_video_size;
        }
    }
}

