package dao.entity;

import java.util.ArrayList;
import java.util.List;

public class AuthorEntity {

    private static long idCounnter=1;

    private Long id;

    private String name;

    private List<BookEntity> books=new ArrayList<>();

    public AuthorEntity(String name) {
        this.name = name;
        this.id = idCounnter++;
    }
    public void addBook(BookEntity book){
        books.add(book);
    }


    public static long getIdCounnter() {
        return idCounnter;
    }

    public static void setIdCounnter(long idCounnter) {
        AuthorEntity.idCounnter = idCounnter;
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

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
