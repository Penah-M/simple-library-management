package dto.response;

public class BookResponse {

    private Long id;
    private String name;
    private String authorName;
    private boolean available;


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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BookResponse(){

    };


    public BookResponse(Long id, String name, String authorName, boolean available) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.available = available;
    }
}
