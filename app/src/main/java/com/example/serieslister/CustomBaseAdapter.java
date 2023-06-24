package com.example.serieslister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class CustomBaseAdapter extends BaseAdapter {

    Context ctx;
    private final String[] series;
    private final int[] seriesImages;
    private final LayoutInflater layoutInflater;

    public CustomBaseAdapter(Context ctx, String[] series, int[] seriesImages) {
        this.ctx = ctx;
        this.series = series;
        this.seriesImages = seriesImages;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return series.length;
    }

    @Override
    public Object getItem(int position) {
        return Arrays.stream(series).findFirst();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.activity_custom_list_viewer, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textImage);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageIcon);

        textView.setText(series[position]);
        imageView.setImageResource(seriesImages[position]);

        return convertView;
    }
}
