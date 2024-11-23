package org.example.user;

public class UserModel {
    private String email;
    private String password;
    private String role;
    private String username;

    private String created_at;
    private String updated_at;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getCreatedAt() { // Add getter for created_at
        return created_at;
    }

    public void setCreatedAt(String created_at) { // Add setter for created_at
        this.created_at = created_at;
    }

    public String getUpdatedAt() { // Add getter for updated_at
        return updated_at;
    }

    public void setUpdatedAt(String updated_at) { // Add setter for updated_at
        this.updated_at = updated_at;
    }
}
