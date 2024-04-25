package io.github.swarnaka.userauthservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")

public class User {
	
	@Id
    private String id;
    private String username;
    private String password;
    
 // Standard getters and setters for the id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Standard getters and setters for the username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // The getPassword method needs to return the actual password
    public String getPassword() {
        return password;
    }

    // The setPassword method to set the user's password
    public void setPassword(String password) {
        this.password = password;
    }

}
