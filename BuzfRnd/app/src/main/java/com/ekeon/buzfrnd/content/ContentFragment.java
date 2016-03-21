package com.ekeon.buzfrnd.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ekeon.buzfrnd.R;
import com.ekeon.buzfrnd.content.adapter.ContentAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentFragment extends Fragment {

  @Bind(R.id.rv_content) RecyclerView rvContent;

  ContentAdapter contentAdapter;

  public static ContentFragment newInstance() {
    return new ContentFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.content_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    contentAdapter = new ContentAdapter();
    rvContent.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    rvContent.setAdapter(contentAdapter);
  }
}
