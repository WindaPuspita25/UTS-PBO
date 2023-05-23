package com.library.main;

import com.library.book.Book;
import com.library.member.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public boolean removeBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean removeMember(String memberName) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                members.remove(member);
                return true;
            }
        }
        return false;
    }
    public boolean borrowBook(String memberName, String bookTitle) {
        Member borrower = findMember(memberName);
        Book book = findAvailableBook(bookTitle);
        if (borrower != null && book != null) {
            borrower.getBorrowedBooks().add(book);
            book.setAvailability(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(String memberName, String bookTitle) {
        Member borrower = findMember(memberName);
        Book book = findBorrowedBook(borrower, bookTitle);
        if (borrower != null && book != null) {
            borrower.getBorrowedBooks().remove(book);
            book.setAvailability(true);
            return true;
        }
        return false;
    }
    private Member findMember(String memberName) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        return null;
    }

    private Book findAvailableBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    private Book findBorrowedBook(Member member, String bookTitle) {
        for (Book book : member.getBorrowedBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public void printBooks() {
        System.out.println("Buku yang tersedia di perpustakaan:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book.getTitle() + " (Penulis: " + book.getAuthor() + ", Tahun Terbit: " + book.getYear() + ")");
            }
        }
    }

    public void printMembers() {
        System.out.println("Daftar anggota perpustakaan:");
        for (Member member : members) {
            System.out.println("- " + member.getName() + " (Alamat: " + member.getAddress() + ")");
        }
    }

    public void printBorrowedBooks() {
        System.out.println("Buku yang sedang dipinjam:");
        for (Member member : members) {
            List<Book> borrowedBooks = member.getBorrowedBooks();
            if (!borrowedBooks.isEmpty()) {
                System.out.println("Anggota: " + member.getName());
                for (Book book : borrowedBooks) {
                    System.out.println("- " + book.getTitle() + " (Penulis: " + book.getAuthor() + ", Tahun Terbit: " + book.getYear() + ")");
                }
                System.out.println();
            }
        }
    }
}