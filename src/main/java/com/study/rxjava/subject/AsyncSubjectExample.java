package com.study.rxjava.subject;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncSubjectExample {
    private static final Logger log = LoggerFactory.getLogger(AsyncSubjectExample.class);

    public void async(){
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(s -> log.info("#1 subscribe : {}", s)); // last
        subject.onNext("first");
        subject.onNext("second");
        subject.subscribe(s -> log.info("#2 subscribe : {}", s)); // last
        subject.onNext("third");
        subject.onNext("last");
        subject.onComplete();
    }

    public void asyncWithArray(){
        Float[] temperatures = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperatures);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(f -> log.info("subscribe : {}", f)); // 12.5f

        source.subscribe(subject);
    }

    public void afterOnComplete(){
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);
        subject.subscribe(i -> log.info("#1 subscribe : {}", i)); // 12
        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(i -> log.info("#2 subscribe : {}", i)); // 12
        subject.subscribe(i -> log.info("#3 subscribe : {}", i)); // 12
    }
}
