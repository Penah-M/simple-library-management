package service;

import dto.request.BookRequest;
import dto.response.BookResponse;
import dao.entity.AuthorEntity;
import dao.entity.BookEntity;
import dao.entity.UserEntity;
import exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class LibraryService {

    private static final Logger log = Logger.getLogger(LibraryService.class.getName());
    private final List<BookEntity> books = new ArrayList<>();
    private final List<AuthorEntity> authors = new ArrayList<>();
    private final Map<Long, UserEntity> users = new HashMap<>();


    public BookResponse addBook(BookRequest request) {
        AuthorEntity author = findOrCreateAuthor(request.getAuthorName());
        BookEntity book = new BookEntity(request.getName(), author);
        author.addBook(book);
        books.add(book);
        log.info("'"+book.getName()+"'" +" Yeni kitab elave olundu");
        System.out.println(" Yeni kitab əlavə olundu: " + book.getName());
        return mapToResponse(book);
    }


    public void borrowBook(Long userId, Long bookId) {
        BookEntity book = findBookById(bookId);
        if (!book.isAvailable()){
            log.warning(book.getName()+" Axtariginiz kitab artiq icarededir ");
            throw new RuntimeException("Kitab artıq icarədədir!");
        }
        if (!users.containsKey(userId)) {
            log.warning(userId+ " Axtardiginiz itifadeci tapilmadi");
            throw new NotFoundException("İstifadəçi tapılmadı!");
        }

        book.setAvailable(false);
        book.setBorrowedByUserId(userId);
        book.setBorrowedAt(LocalDateTime.now());

        log.info(book.getName()+" Kitabi icareye goturdunuz");
        System.out.println("Kitab icarəyə götürüldü: " + book.getName());
    }


    public void returnBook(Long bookId) {
        BookEntity book = findBookById(bookId);
        book.setAvailable(true);
        book.setBorrowedByUserId(null);
        book.setBorrowedAt(null);
        System.out.println(" Kitab qaytarıldı: " + book.getName());
    }

    public List<BookResponse> getAllAvailableBooks(int page, int size) {
        return books.stream()
                .filter(BookEntity::isAvailable)
                .skip((page - 1L) * size)
                .limit(size)
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> getBooksByAuthor(String letter) {
        return books.stream()
                .filter(b -> b.getAuthor().getName().startsWith(letter))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private AuthorEntity findOrCreateAuthor(String authorName) {
        return authors.stream()
                .filter(a -> a.getName().equalsIgnoreCase(authorName))
                .findFirst()
                .orElseGet(() -> {
                    AuthorEntity newAuthor = new AuthorEntity(authorName);
                    authors.add(newAuthor);
                    return newAuthor;
                });
    }

    private BookEntity findBookById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    log.warning(  "..Axtardiginiz kitab yoxdur");
                   return new NotFoundException("Kitab tapılmadı ID: " + id);
                });
    }

    private BookResponse mapToResponse(BookEntity book) {
        return new BookResponse(book.getId(), book.getName(), book.getAuthor().getName(), book.isAvailable());
    }


    public void addUser(String name,String email) {
        UserEntity user = new UserEntity(name,email);
        users.put(user.getId(), user);
    }
}

