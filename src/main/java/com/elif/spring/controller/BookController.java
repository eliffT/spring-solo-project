package com.elif.spring.controller;

import com.elif.spring.entity.Book;
import com.elif.spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public Book save(@RequestBody Book book){
        return bookService.save(book);

    }

    @GetMapping("/list")
    public List<Book> listAllBook(){
        return bookService.getAllBook();
    }


}
