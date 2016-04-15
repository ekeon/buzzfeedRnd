package com.ekeon.buzfrnd.VideoView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

/**
 * Created by Ekeon on 2016. 4. 12..
 */
public class TvVideoView extends TextureView implements TextureView.SurfaceTextureListener, Controller {

  private Uri videoUri;
  private MediaPlayer mediaPlayer;

  public TvVideoView(Context context) {
    this(context, null, 0);
  }

  public TvVideoView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public TvVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setSurfaceTextureListener(this);
  }

  public void setVideoURI(Uri videoUri) {
    this.videoUri = videoUri;
  }

  @Override
  public void start() {
    mediaPlayer.start();
  }

  @Override
  public void stop() {
    mediaPlayer.stop();
  }

  @Override
  public boolean isPlaying() {
    return mediaPlayer.isPlaying();
  }

  @Override
  public boolean isPlayEnd() {
    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
      @Override
      public void onCompletion(MediaPlayer mp) {
      }
    });
    return false;
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
  }

  @Override
  public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
    Surface surface = new Surface(surfaceTexture);

    try {
      mediaPlayer = new MediaPlayer();
      mediaPlayer.setSurface(surface);
      mediaPlayer.setLooping(false);
      mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
          mp.start();
        }
      });
      mediaPlayer.setDataSource(getContext(), videoUri);
      mediaPlayer.prepareAsync();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

  }

  @Override
  public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
    surface.release();
    return false;
  }

  @Override
  public void onSurfaceTextureUpdated(SurfaceTexture surface) {

  }
}
