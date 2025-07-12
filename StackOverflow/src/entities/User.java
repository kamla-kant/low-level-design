package entities;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String email;
    private int reputation;

    public User(String name, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        reputation = 0;
    }

    public void updateReputation(int value) {
        reputation+=value;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }
}
