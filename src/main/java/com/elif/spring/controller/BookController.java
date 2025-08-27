package com.elif.spring.controller;

import com.elif.spring.entity.Book;
import com.elif.spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);

    }

    @GetMapping
    public List<Book> listAllBook(){
        return bookService.getAllBook();
    }


}
