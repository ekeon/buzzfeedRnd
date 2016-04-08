package com.ekeon.buzfrnd.content.event;

/**
 * Created by Ekeon on 2016. 4. 8..
 */
public class OnSendVideoPostionEvent {

  int postion;

  public OnSendVideoPostionEvent(int postion) {
    this.postion = postion;
  }

  public int getPostion() {
    return postion;
  }
}
