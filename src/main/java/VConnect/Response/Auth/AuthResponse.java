package VConnect.Response.Auth;

public class AuthResponse {
    private String username;
    private String email;
    private Boolean isLogged;
    private String text;

    public AuthResponse(String username, String email, Boolean isLogged, String text) {
        this.username = username;
        this.email = email;
        this.isLogged = isLogged;
        this.text = text;
    }

    public AuthResponse() {
    }

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

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
