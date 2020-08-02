package com.study.rxjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RxjavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(RxjavaApplication.class, args);
        FirstExample example = new FirstExample();

        example.emit();

        example.redGreenBlue();

        example.create();

        example.fromArray();

        example.fromArrayBoxed();
    }

}
