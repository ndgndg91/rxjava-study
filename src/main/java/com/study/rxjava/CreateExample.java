package com.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateExample {
    private static final Logger log = LoggerFactory.getLogger(CreateExample.class);

    public void create(){
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onNext(400);
                    emitter.onComplete();
                }
        );

        Disposable d = source.subscribe(integer -> log.info("{}", integer));
        log.info("isDisposable() : {}", d.isDisposed());
    }
}
