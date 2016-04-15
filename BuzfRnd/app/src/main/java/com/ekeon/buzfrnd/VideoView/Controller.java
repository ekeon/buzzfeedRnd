package com.ekeon.buzfrnd.VideoView;

/**
 * Created by Ekeon on 2016. 4. 14..
 */
public interface Controller {
  void start();

  void stop();

  boolean isPlaying();

  boolean isPlayEnd();
}
