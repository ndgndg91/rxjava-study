package com.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

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

    public void fromArray(){
        Integer[] array = {100, 200, 300, 400};
        Observable<Integer> source = Observable.fromArray(array);
        Disposable d = source.subscribe(integer -> log.info("{}", integer));

        log.info("isDisposable() : {}", d.isDisposed());
    }

    public void fromArrayBoxed(){
        int[] array = new int[]{1000, 2000 ,3000};
        Integer[] integers = IntStream.of(array).boxed().toArray(Integer[]::new);
        Observable<Integer> source = Observable.fromArray(integers);
        Disposable d = source.subscribe(integer -> log.info("{}", integer));

        log.info("isDisposable() : {}", d.isDisposed());
    }

}
