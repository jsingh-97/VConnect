package VConnect.Aggregator.Request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SignUpRequest {
    @JsonProperty(value = "name",required = true)
    private String name;
    @JsonProperty(value = "email",required = true)
    private String email;
    @JsonProperty(value = "password",required = true)
    private String password;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "company")
    private String company;
    @JsonProperty(value = "school")
    private String school;
    @JsonProperty("course")
    private String course;


}
