package com.study.rxjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RxjavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(RxjavaApplication.class, args);
        FirstExample firstExample = new FirstExample();

        firstExample.emit();

        firstExample.redGreenBlue();

        CreateExample createExample = new CreateExample();

        createExample.create();

        FromExample fromExample = new FromExample();

        fromExample.fromArray();

        fromExample.fromArrayBoxed();

        fromExample.fromIterableOfList();

        fromExample.fromIterableOfSet();

        fromExample.usingBlockingQueue();

        fromExample.fromCallable();

        fromExample.fromFuture();

        fromExample.fromPublisher();

        SingleExample singleExample = new SingleExample();

        singleExample.just();

        singleExample.fromObservable();

        singleExample.singleFunction();

        singleExample.firstFunction();

        singleExample.singleFromEmpty();

        singleExample.takeFunction();
    }

}
