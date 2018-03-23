package pl.ddl.todo.login;

public class UserLoggedInEvent {

    private final String username;

    public UserLoggedInEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
