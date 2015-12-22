package com.hong.mobileplayer.domain;

/**
 * Created by Hong on 2015/12/22.
 */
public class MediaItem {
    private long size;
    private String title;
    private long duration;
    private String data;


    public MediaItem(long size, String title, long duration, String data) {
        this.size = size;
        this.title = title;
        this.duration = duration;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "size=" + size +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", data='" + data + '\'' +
                '}';
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
