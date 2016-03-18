package com.ekeon.buzfrnd.content.hodler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ekeon.buzfrnd.R;

import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentVideoHolder extends RecyclerView.ViewHolder {

  public static ContentVideoHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.content_video_holder, null);
    return new ContentVideoHolder(itemView);
  }

  public ContentVideoHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
