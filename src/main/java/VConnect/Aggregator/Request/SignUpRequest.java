package VConnect.Aggregator.Request;


import com.fasterxml.jackson.annotation.JsonProperty;



public class SignUpRequest {
    @JsonProperty("email")
    private String useremail;
    @JsonProperty("name")
    private String username;
    @JsonProperty("password")
    private String password;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
