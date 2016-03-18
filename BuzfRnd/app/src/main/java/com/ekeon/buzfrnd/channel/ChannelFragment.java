package com.ekeon.buzfrnd.channel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ekeon.buzfrnd.R;
import com.ekeon.buzfrnd.channel.adapter.ChannelAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ChannelFragment extends Fragment {

  @Bind(R.id.twv_channel) RecyclerView twvChannel;

  ChannelAdapter channelAdapter;

  public static ChannelFragment newInstance() {
    return new ChannelFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.channel_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    channelAdapter = new ChannelAdapter();
    twvChannel.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    twvChannel.setAdapter(channelAdapter);
  }
}
