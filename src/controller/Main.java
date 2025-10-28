package controller;

import dto.request.BookRequest;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();

        library.addUser("Aysel","ayseleliyeva@Gmail.com");
        library.addUser("Murad","nebizade@gmail.com");

        library.addBook(new BookRequest("Səfillər", "Victor Hugo"));
        library.addBook(new BookRequest("Notre Dame", "Victor Hugo"));
        library.addBook(new BookRequest("1984", "George Orwell"));

        library.borrowBook(1L, 1L);
        library.returnBook(1L);

        library.getAllAvailableBooks(1, 5).forEach(
                b -> System.out.println(b.getName() + " - " + b.getAuthorName())
        );

        library.getBooksByAuthor("V").forEach(
                b -> System.out.println("Müəllif(V): " + b.getName())
        );


    }
}
