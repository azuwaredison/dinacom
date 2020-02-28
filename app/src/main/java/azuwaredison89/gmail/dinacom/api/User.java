package azuwaredison89.gmail.dinacom.api;

public class User {

    private String username, email;
    private int id;
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

}
