package com.elif.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Book> bookList =  new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
        book.setStudent(this);
    }

}
