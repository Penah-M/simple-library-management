package dao.entity;

import java.time.LocalDateTime;

public class BookEntity {
    private static  long idCounter=1;

    private Long id;

    private String name;

    private boolean available;

    private Long borrowedByUserId;

    private LocalDateTime borrowedAt;

    private AuthorEntity author;

    public BookEntity(String name,AuthorEntity author) {
        this.id = idCounter++;
        this.name = name;
        this.available = true;
        this.borrowedByUserId = null;
        this.borrowedAt = null;
        this.author = author;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        BookEntity.idCounter = idCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getBorrowedByUserId() {
        return borrowedByUserId;
    }

    public void setBorrowedByUserId(Long borrowedByUserId) {
        this.borrowedByUserId = borrowedByUserId;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDateTime borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }
}
