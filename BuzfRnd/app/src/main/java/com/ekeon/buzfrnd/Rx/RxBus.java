package com.ekeon.buzfrnd.Rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Ekeon on 2016. 4. 8..
 */
public class RxBus {

    public static RxBus instance;

    public static RxBus getInstance() {
      if (instance == null) {
        synchronized (RxBus.class) {
          if (instance == null) {
            instance = new RxBus();
          }
        }
      }

      return instance;
    }

    private final Subject<Object, Object> bus =
            new SerializedSubject<>(PublishSubject.create());

    public void send(Object event) {
      bus.onNext(event);
    }

    public Observable<Object> toObservable() {
      return bus;
    }
  }
