package com.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ConnectableObservableExample {
    private static final Logger log = LoggerFactory.getLogger(ConnectableObservableExample.class);

    public void connectable() throws InterruptedException {
        String[] array = {"1", "3", "5"};
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> array[i])
                .take(array.length);

        ConnectableObservable<String> source = balls.publish();
        source.subscribe(s -> log.info("Subscriber #1 => {}", s));
        source.subscribe(s -> log.info("Subscriber #2 => {}", s));
        source.connect();

        sleep(250);
        source.subscribe(s -> log.info("Subscriber #3 => {}", s));
        sleep(100);
    }
}
