package com.ekeon.buzfrnd.channel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ekeon.buzfrnd.channel.hodler.ChannelGridHolder;


/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ChannelAdapter extends RecyclerView.Adapter {

  private final int TYPE_CHANNEL_ITEM = 0;

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    RecyclerView.ViewHolder viewHolder = ChannelGridHolder.newInstance(context);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 7;
  }

  @Override
  public int getItemViewType(int position) {
    return TYPE_CHANNEL_ITEM;
  }
}
