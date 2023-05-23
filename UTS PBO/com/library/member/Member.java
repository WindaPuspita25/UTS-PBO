package com.library.member;

import com.library.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String address;
    private List<Book> borrowedBooks;

    public Member(String name, String address) {
        this.name = name;
        this.address = address;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}