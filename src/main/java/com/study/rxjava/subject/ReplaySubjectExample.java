package com.study.rxjava.subject;

import io.reactivex.subjects.ReplaySubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplaySubjectExample {
    private static final Logger log = LoggerFactory.getLogger(ReplaySubjectExample.class);

    public void replay(){
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(s -> log.info("#1 subscribe : {}", s));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(s -> log.info("#2 subscribe : {}", s));
        subject.onNext("5");
        subject.onComplete();
    }
}
