package com.ekeon.buzfrnd;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ekeon.buzfrnd.channel.ChannelFragment;
import com.ekeon.buzfrnd.content.ContentFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  private Fragment contentFragment;
  private Fragment channelFragment;

  @OnClick(R.id.btn_content)
  void onContentBtnClick() {
    if (contentFragment == null) {
      contentFragment = ContentFragment.newInstance();
    }

    if (channelFragment != null) {
      removeFragment(channelFragment);
    }

    replaceFragment(contentFragment);
  }

  @OnClick(R.id.btn_channel)
  void onChannelBtnClick() {
    removeFragment(contentFragment);
    if (channelFragment == null) {
      channelFragment = ChannelFragment.newInstance();
    }

    replaceFragment(channelFragment);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    contentFragment = ContentFragment.newInstance();
    replaceFragment(contentFragment);
  }

  /**
   * 프래그먼트 넣어주고 호출
   * @param fragment
   */
  private void replaceFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.main_fragment, fragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

  /**
   * 프래그먼트 넣어주고 제거
   * @param fragment
   */
  private void removeFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.main_fragment, fragment);
    transaction.remove(fragment);
    transaction.commit();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
}
