package com.ekeon.buzfrnd.content.hodler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ekeon.buzfrnd.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentTitleHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.tv_content_title) TextView tvContentTitle;

  public static ContentTitleHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.content_title_holder, null);
    return new ContentTitleHolder(itemView);
  }

  public ContentTitleHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void setText(String title) {
    tvContentTitle.setText("" + title);
  }

}
