package com.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FromExample {
    private static final Logger log = LoggerFactory.getLogger(FromExample.class);

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

    public void fromIterableOfList(){
        List<String> names = List.of("john", "동길", "merry", "bob");

        Observable<String> source = Observable.fromIterable(names);
        Disposable d = source.subscribe(log::info);

        log.info("isDisposable(): {}", d.isDisposed());
    }

    public void fromIterableOfSet(){
        Set<String> cities = Set.of("서울", "부산", "대전", "대구", "울산");

        Observable<String> source = Observable.fromIterable(cities);
        Disposable d = source.subscribe(log::info);

        log.info("isDisposable(): {}", d.isDisposed());
    }

    public void usingBlockingQueue(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("first");
        blockingQueue.add("second");
        blockingQueue.add("third");

        //capacity is 3, so next line occur error.
//        blockingQueue.add("fourth");

        Observable<String> source = Observable.fromIterable(blockingQueue);
        Disposable d = source.subscribe(log::info);

        log.info("isDisposable() : {}", d.isDisposed());
    }

    public void fromCallable(){
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "sleep 1 second!";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(log::info);
    }

    public void fromFuture(){
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(2000);
            return "sleep 2 seconds!";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(log::info);
    }

    public void fromPublisher(){
        Publisher<String> publisher = (Subscriber<? super String> s) -> {
            s.onNext("Hello Observable.fromPublisher()");
            s.onComplete();
        };

        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(log::info);
    }
}
