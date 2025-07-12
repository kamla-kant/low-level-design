package entities;

import java.util.UUID;

public class Tag {
    private String id;
    private String tagName;

    public Tag(String tagName){
        this.id = UUID.randomUUID().toString();
        this.tagName = tagName;
    }

    public String getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }
}
