import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String email;
    private String fullName;

    // Constructor
    public User(String username, String email, String fullName) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
    }

    // Getter và Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Chuyển đổi đối tượng User thành chuỗi (có thể hữu ích cho debugging)
    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', fullName='" + fullName + "'}";
    }
}
