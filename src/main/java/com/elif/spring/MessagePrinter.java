package com.elif.spring;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    public void printMessage(){
        System.out.println("MessagePrinter");
    }
}
