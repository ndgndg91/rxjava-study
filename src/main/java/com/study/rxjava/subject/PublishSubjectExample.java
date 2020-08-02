package com.study.rxjava.subject;

import io.reactivex.subjects.PublishSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublishSubjectExample {
    private static final Logger log = LoggerFactory.getLogger(PublishSubjectExample.class);

    public void publish(){
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(s -> log.info("#1 subscribe : {}", s));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(s -> log.info("#2 subscribe : {}", s));
        subject.onNext("5");
        subject.onComplete();
    }
}
