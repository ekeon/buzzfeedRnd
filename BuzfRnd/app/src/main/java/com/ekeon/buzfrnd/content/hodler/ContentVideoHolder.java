package com.ekeon.buzfrnd.content.hodler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ekeon.buzfrnd.R;
import com.ekeon.buzfrnd.RxBus;
import com.ekeon.buzfrnd.content.event.OnSendVideoPostionEvent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentVideoHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.tv_position) TextView tvPosition;

  private int position;
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
    rxBus.send(new OnSendVideoPostionEvent(position));
    tvPosition.setText("" + position);
  }

}
