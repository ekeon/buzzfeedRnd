package com.ekeon.buzfrnd.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ekeon.buzfrnd.R;
import com.ekeon.buzfrnd.Rx.RxBus;
import com.ekeon.buzfrnd.ScrollManager;
import com.ekeon.buzfrnd.content.adapter.ContentAdapter;
import com.ekeon.buzfrnd.content.event.OnVideoStartEvent;
import com.ekeon.buzfrnd.content.event.OnVideoStopEvent;
import com.ekeon.buzfrnd.content.model.ContentModel;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ekeon on 2016. 3. 18..
 */
public class ContentFragment extends Fragment implements ScrollManager {

  @Bind(R.id.rv_content) RecyclerView rvContent;
  private LinearLayoutManager rvContentManager;

  List<ContentModel> contentList = new ArrayList<>();

  private ContentAdapter contentAdapter;
  private ContentModel contentModel = new ContentModel();

  private RvScrollState rvScrollState = RvScrollState.DOWN;

  private int position;

  public static ContentFragment newInstance() {
    return new ContentFragment();
  }

  @OnClick(R.id.btn_play)
  void videoStart() {
    RxBus.getInstance().send(new OnVideoStartEvent());
  }

  @OnClick(R.id.btn_stop)
  void videoStop() {
    RxBus.getInstance().send(new OnVideoStopEvent());
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
    rvContent.setLayoutManager(new LinearLayoutManager(this.getContext()));
    rvContent.setAdapter(contentAdapter);
    rvContent.addOnScrollListener(scrollListener);
    rvContentManager = (LinearLayoutManager) rvContent.getLayoutManager();
  }

  private void getRecyclerViewMiddlePosition() {
//    rvContentManager.findLastCompletelyVisibleItemPosition();
//    rvContentManager.findFirstCompletelyVisibleItemPosition();
    Log.d("TAG", "first : " + rvContentManager.findFirstCompletelyVisibleItemPosition());
    Log.d("TAG", "last : " + rvContentManager.findLastCompletelyVisibleItemPosition());
  }

  private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      super.onScrolled(recyclerView, dx, dy);
      getRecyclerViewMiddlePosition();
      if (dy > 0) {
        rvScrollState = RvScrollState.DOWN;
      } else {
        rvScrollState = RvScrollState.UP;
      }

      canPlaynextvideo();
      getPosition();
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      super.onScrollStateChanged(recyclerView, newState);
      switch (newState) {
        case 0 : //TODO 스크롤멈춤
          break;
        case 1 : //TODO 스크롤멈춤 + 화면 터치중
          isScrollEnd();
          break;
        case 2 : //TODO 스크롤중
          break;
      }
    }
  };

  private enum RvScrollState {
    UP, DOWN
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

  @Override
  public void getPosition() {
    position = contentAdapter.getVideoPosition();
  }

  @Override
  public void isScroll() {

  }

  @Override
  public void isScrollEnd() {
    contentAdapter.setPlayVideoPostion(position);
  }

  @Override
  public void canPlaynextvideo() {

  }

  @Override
  public void setPostionCenter() {

  }

  @Override
  public void showVideoController() {

  }

  @Override
  public void hideVideoController() {

  }

}
