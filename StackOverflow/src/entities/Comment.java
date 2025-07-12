package entities;

import java.time.LocalDate;
import java.util.UUID;

public class Comment {
    private String id;
    private String content;
    private User author;
    private LocalDate creationDate;

    public Comment(User author, String content){
        id = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
        creationDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
