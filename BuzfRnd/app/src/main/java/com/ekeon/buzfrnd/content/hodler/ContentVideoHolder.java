package com.ekeon.buzfrnd.content.hodler;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ekeon.buzfrnd.R;
import com.ekeon.buzfrnd.Rx.RxBus;
import com.ekeon.buzfrnd.VideoView.TvVideoView;
import com.ekeon.buzfrnd.content.event.OnVideoStartEvent;
import com.ekeon.buzfrnd.content.event.OnVideoStopEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentVideoHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.tv_position) TextView tvPosition;
  @Bind(R.id.vv_video) TvVideoView vvVideo;

  private RxBus rxBus = new RxBus();

  public static ContentVideoHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.content_video_holder, null);
    return new ContentVideoHolder(itemView);
  }

  public ContentVideoHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void setText(int position) {
    tvPosition.setText(String.format("%d", position));
  }

  public void setVideo() {
    vvVideo.setVisibility(View.VISIBLE);
    vvVideo.setVideoURI(Uri.parse("http://techslides.com/demos/sample-videos/small.mp4"));
  }

  public void hideVideo() {
    vvVideo.setVisibility(View.GONE);
  }

  public void videoStop() {
    RxBus.getInstance().toObservable().subscribe(new Action1<Object>() {
      @Override
      public void call(Object o) {
        if (o instanceof OnVideoStopEvent) {
          vvVideo.stop();
          Log.d("TAG", "videoStop");
        }
      }
    });
  }

  public void videoStart() {
    RxBus.getInstance().toObservable().subscribe(new Action1<Object>() {
      @Override
      public void call(Object o) {
        if (o instanceof OnVideoStartEvent) {
          vvVideo.start();
          Log.d("TAG", "videoStop");
        }
      }
    });
  }
  
}
