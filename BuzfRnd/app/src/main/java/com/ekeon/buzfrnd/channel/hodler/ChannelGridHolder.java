package com.ekeon.buzfrnd.channel.hodler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ekeon.buzfrnd.R;

import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ChannelGridHolder extends RecyclerView.ViewHolder {

  public static ChannelGridHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.channel_grid_holder, null);
    return new ChannelGridHolder(itemView);
  }

  public ChannelGridHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
