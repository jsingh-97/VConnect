package VConnect.Response.Auth;

import VConnect.Model.Auth.UserData;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AuthResponse {
    private String username;
    private String email;
    private String desgination;
    private String city;
    private String company;
    private String jobType;
    private String school;
    private String course;
    private String gradYear;
    private Boolean isLogged;
    private String text;

    public AuthResponse(String username, String email, String desgination, String city, String company, String jobType, String school, String course, String gradYear, Boolean isLogged, String text) {
        this.username = username;
        this.email = email;
        this.desgination = desgination;
        this.city = city;
        this.company = company;
        this.jobType = jobType;
        this.school = school;
        this.course = course;
        this.gradYear = gradYear;
        this.isLogged = isLogged;
        this.text = text;
    }

    public AuthResponse(String text) {
        this.text = text;
    }

    public AuthResponse() {
    }

    public void addDetails(UserData userData) {
        this.city=userData.getCity();
        this.company=userData.getCompany();
        this.course=userData.getCourse();
        this.school=userData.getSchool();
        this.desgination=userData.getDesignation();
        this.email=userData.getEmail();
        this.username=userData.getName();
    }
}
