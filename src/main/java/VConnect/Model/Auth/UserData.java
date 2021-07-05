package VConnect.Model.Auth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "userdata")
@Getter@Setter@AllArgsConstructor
public class UserData {
    @Column(name="name")
    private String name;
    @Id
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phone")
    private String phone;
    @Column(name="designation")
    private String designation;
    @Column(name="city")
    private String city;
    @Column(name="company")
    private String company;

    @Column(name="school")
    private String school;
    @Column(name="course")
    private String course;
    public UserData() {
    }


}
