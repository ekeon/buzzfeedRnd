package com.ekeon.buzfrnd.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ekeon.buzfrnd.R;
import com.ekeon.buzfrnd.content.adapter.ContentAdapter;
import com.ekeon.buzfrnd.model.ContentModel;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentFragment extends Fragment{

  @Bind(R.id.rv_content) RecyclerView rvContent;

  List<ContentModel> contentList = new ArrayList<>();

  private ContentAdapter contentAdapter;
  private ContentModel contentModel = new ContentModel();

  public static ContentFragment newInstance() {
    return new ContentFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.content_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    //더미값으로 20개 컨텐츠넣어줌.
    setDummyContent();
    setAdapter();
    setRecycleView();
  }

  private void setRecycleView() {
    rvContent.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    rvContent.setAdapter(contentAdapter);
  }

  private void setAdapter() {
    if (contentAdapter == null) {
      contentAdapter = new ContentAdapter();
      contentAdapter.addAll(contentList);
    }
  }

  private void setDummyContent() {
    if (contentList.isEmpty()) {
      for (int i = 0; i < 20; i++) {
        contentModel.setImage("i : " + i);
        contentModel.setVideoUrl("v : " + i);
        contentModel.setTitle("t : " + i);

        contentList.add(contentModel);
      }
    }
  }

}
