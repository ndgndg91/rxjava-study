package com.study.rxjava;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleExample {
    private static final Logger log = LoggerFactory.getLogger(SingleExample.class);

    public void just(){
        Single<String> source = Single.just("just single!");
        source.subscribe((Consumer<String>) log::info);
    }

    public void fromObservable(){
        Observable<String> source = Observable.just("Hello single");
        Single.fromObservable(source).subscribe((Consumer<String>) log::info);
    }

    public void singleFunction(){
        Observable.just("Hello single")
                .single("default item")
                .subscribe((Consumer<String>) log::info);
    }

    public void firstFunction(){
        String[] colors = {"RED", "GREEN", "BLUE"};
        Observable.fromArray(colors)
                .first("default array")
                .subscribe((Consumer<String>) log::info);
    }

    public void singleFromEmpty(){
        Observable.empty()
                .single("default empty")
                .subscribe(System.out::println);
    }

    public void takeFunction(){
        Observable.just("first", "second")
                .take(1)
                .single("default take")
                .subscribe((Consumer<String>) log::info);
    }
}
