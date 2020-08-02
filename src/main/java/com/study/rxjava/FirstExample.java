package com.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstExample {
    private static final Logger log = LoggerFactory.getLogger(FirstExample.class);
    public void emit(){
        Disposable subscribe = Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(integer -> log.info("{}", integer));

        log.info("isDisposable() : {}", subscribe.isDisposed());
    }

    public void redGreenBlue(){
        Observable<String> source = Observable.just("RED", "Green", "Blue");

        Disposable d = source.subscribe(
                v -> log.info("onNext() : value : {}", v),
                err -> log.error("onError() : err : {}", err.getMessage()),
                () -> log.info("onComplete()")
        );

        log.info("isDisposable() : {}", d.isDisposed());
    }
}
