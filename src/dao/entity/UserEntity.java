package dao.entity;

import java.util.List;

public class UserEntity {

    private static  long idCounter=1;

    private Long id;

    private String name;

    private String email;

    private List<Long> borrowedBookIds;

    public UserEntity(String name,String email){
        this.name=name;
        this.email=email;
        this.id=idCounter++;
        this.borrowedBookIds=null;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        UserEntity.idCounter = idCounter;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getBorrowedBookIds() {
        return borrowedBookIds;
    }
    public void setBorrowedBookIds(List<Long> borrowedBookIds) {
        this.borrowedBookIds = borrowedBookIds;
    }


}
