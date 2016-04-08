package com.ekeon.buzfrnd.content.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ekeon.buzfrnd.content.hodler.ContentTitleHolder;
import com.ekeon.buzfrnd.content.hodler.ContentVideoHolder;
import com.ekeon.buzfrnd.model.ContentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekeon on 2016. 3. 21..
 */
public class ContentAdapter extends RecyclerView.Adapter {

  private final int TYPE_TITLE = 0;
  private final int TYPE_VIDEO = 1;

  private List<ContentModel> list = new ArrayList<>();

  public void addAll(List<ContentModel> list) {
    this.list.addAll(list);
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    Context context = parent.getContext();

    switch (viewType) {
      case TYPE_TITLE:
        viewHolder = ContentTitleHolder.newInstance(context);
        break;
      case TYPE_VIDEO:
        viewHolder = ContentVideoHolder.newInstance(context);
        break;
    }
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof ContentTitleHolder) {
      ((ContentTitleHolder) holder).setText("" + position/2);
    }

    if (holder instanceof ContentVideoHolder) {
      ((ContentVideoHolder) holder).setText(position/2);
    }

  }

  @Override
  public int getItemCount() {
    return list.size()*2;
  }

  @Override
  public int getItemViewType(int position) {
    if (position % 2 == 0) {
      return TYPE_TITLE;
    }

    if (position % 2 == 1) {
      return TYPE_VIDEO;
    }
    return super.getItemViewType(position);
  }
}
