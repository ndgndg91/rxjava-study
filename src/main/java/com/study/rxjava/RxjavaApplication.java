package com.study.rxjava;

import com.study.rxjava.subject.AsyncSubjectExample;
import com.study.rxjava.subject.BehaviorSubjectExample;
import com.study.rxjava.subject.PublishSubjectExample;
import com.study.rxjava.subject.ReplaySubjectExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RxjavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(RxjavaApplication.class, args);

//        firstExample();
//        createExample();
//        fromExample();
//        singleExample();
//        asyncSubjectExample();
//        behaviorSubjectExample();
//        publishSubjectExample();
//        replaySubjectExample();
        connectableObservableExample();
    }

    private static void firstExample() {
        FirstExample firstExample = new FirstExample();
        firstExample.emit();
        firstExample.redGreenBlue();
    }

    private static void createExample() {
        CreateExample createExample = new CreateExample();
        createExample.create();
    }

    private static void fromExample() {
        FromExample fromExample = new FromExample();
        fromExample.fromArray();
        fromExample.fromArrayBoxed();
        fromExample.fromIterableOfList();
        fromExample.fromIterableOfSet();
        fromExample.usingBlockingQueue();
        fromExample.fromCallable();
        fromExample.fromFuture();
        fromExample.fromPublisher();
    }

    private static void singleExample() {
        SingleExample singleExample = new SingleExample();
        singleExample.just();
        singleExample.fromObservable();
        singleExample.singleFunction();
        singleExample.firstFunction();
        singleExample.singleFromEmpty();
        singleExample.takeFunction();
    }

    private static void asyncSubjectExample() {
        AsyncSubjectExample subjectExample = new AsyncSubjectExample();
        subjectExample.async();
        subjectExample.asyncWithArray();
        subjectExample.afterOnComplete();
    }

    private static void behaviorSubjectExample() {
        BehaviorSubjectExample behaviorSubjectExample = new BehaviorSubjectExample();
        behaviorSubjectExample.behavior();
    }

    private static void publishSubjectExample() {
        PublishSubjectExample publishSubjectExample = new PublishSubjectExample();
        publishSubjectExample.publish();
    }

    private static void replaySubjectExample() {
        ReplaySubjectExample replaySubjectExample = new ReplaySubjectExample();
        replaySubjectExample.replay();
    }

    private static void connectableObservableExample() {
        ConnectableObservableExample connectableObservableExample = new ConnectableObservableExample();
        try {
            connectableObservableExample.connectable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
