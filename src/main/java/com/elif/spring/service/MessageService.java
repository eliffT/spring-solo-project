package com.elif.spring.service;

import com.elif.spring.MessagePrinter;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessagePrinter messagePrinter;

    // Constructor Injection
    public MessageService(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public MessagePrinter getMessagePrinter() {
        return messagePrinter;
    }
}
