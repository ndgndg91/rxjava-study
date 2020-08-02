package com.study.rxjava.subject;

import io.reactivex.subjects.BehaviorSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BehaviorSubjectExample {
    private static final Logger log = LoggerFactory.getLogger(BehaviorSubjectExample.class);

    public void behavior(){
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
        subject.subscribe(s -> log.info("#1 subscribe : {}", s));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(s -> log.info("#2 subscribe : {}", s));
        subject.onNext("5");
        subject.onComplete();
    }
}
