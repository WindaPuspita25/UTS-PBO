package com.library.main;

import com.library.book.Book;
import com.library.member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("");
            System.out.println("=========== SISTEM MANAJEMEN PERPUSTAKAAN ============");
            System.out.println("                      Winda's BOOK                    ");
            System.out.println("JL.Majalaya-Cicalengka No.42 Bandung Jawa Barat, 40383");
            System.out.println("=======================================================");
            System.out.println(" ");            
            System.out.println("PILIHAN MENU : ");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Daftar Buku");
            System.out.println("4. Tambah Anggota");
            System.out.println("5. Hapus Anggota");
            System.out.println("6. Daftar Anggota");
            System.out.println("7. Pinjam Buku");
            System.out.println("8. Kembalikan Buku");
            System.out.println("9. Daftar Buku Dipinjam");
            System.out.println("0. Keluar");
            System.out.print("Masukan Pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Membersihkan baris kosong
                    System.out.println("===== TAMBAH BUKU =====");
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan penulis buku: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit buku: ");
                    int year = scanner.nextInt();
                    Book newBook = new Book(title, author, year);
                    library.addBook(newBook);
                    System.out.println("Buku berhasil ditambahkan ke perpustakaan.");
                    break;
                case 2:
                    scanner.nextLine(); // Membersihkan baris kosong
                    System.out.println("===== HAPUS BUKU =====");
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String bookTitle = scanner.nextLine();
                    boolean isRemoved = library.removeBook(bookTitle);
                    if (isRemoved) {
                        System.out.println("Buku berhasil dihapus dari perpustakaan.");
                    } else {
                        System.out.println("Buku tidak ditemukan dalam perpustakaan.");
                    }
                    break;
                case 3:
                    System.out.println("===== DAFTAR BUKU =====");
                    library.printBooks();
                    break;
                case 4:
                    scanner.nextLine(); // Membersihkan baris kosong
                    System.out.println("===== TAMBAH ANGGOTA =====");
                    System.out.print("Masukkan nama anggota: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Masukkan alamat anggota: ");
                    String memberAddress = scanner.nextLine();
                    Member newMember = new Member(memberName, memberAddress);
                    library.addMember(newMember);
                    System.out.println("Anggota berhasil ditambahkan.");
                    break;
                case 5:
                    scanner.nextLine(); // Membersihkan baris kosong
                    System.out.println("===== HAPUS ANGGOTA =====");
                    System.out.print("Masukkan nama anggota yang akan dihapus: ");
                    String memberNameToRemove = scanner.nextLine();
                    boolean isMemberRemoved = library.removeMember(memberNameToRemove);
                    if (isMemberRemoved) {
                        System.out.println("Anggota berhasil dihapus.");
                    } else {
                        System.out.println("Anggota tidak ditemukan.");
                    }
                    break;
                case 6:
                    System.out.println("===== DAFTAR ANGGOTA =====");
                    library.printMembers();
                    break;
                case 7:
                    scanner.nextLine(); // Membersihkan baris kosong
                    System.out.println("===== PINJAM BUKU =====");
                    System.out.print("Masukkan nama anggota: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String bookToBorrow = scanner.nextLine();
                    boolean isBookBorrowed = library.borrowBook(borrowerName, bookToBorrow);
                    if (isBookBorrowed) {
                        System.out.println("Buku berhasil dipinjam.");
                    } else {
                        System.out.println("Gagal meminjam buku. Periksa ketersediaan buku atau anggota yang dimaksud.");
                    }
                    break;
                case 8:
                    scanner.nextLine(); // Membersihkan baris kosong
                    System.out.println("===== KEMBALIKAN BUKU =====");
                    System.out.print("Masukkan nama anggota: ");
                    String borrowerNameToReturn = scanner.nextLine();
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    String bookToReturn = scanner.nextLine();
                    boolean isBookReturned = library.returnBook(borrowerNameToReturn, bookToReturn);
                    if (isBookReturned) {
                        System.out.println("Buku berhasil dikembalikan.");
                    } else {
                        System.out.println("Gagal mengembalikan buku. Periksa buku atau anggota yang dimaksud.");
                    }
                    break;
                case 9:
                    System.out.println("===== DAFTAR BUKU DIPINJAM =====");
                    library.printBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Sistem Manajemen Perpustakaan.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
