package VConnect.Model.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="confirmationtoken")
@AllArgsConstructor@Getter
@Setter
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="token")
    private String token;
    @Column(name="createdAt")
    private Timestamp createdAt;
    @Column(name="expiresAt")
    private Timestamp expiresAt;
    @Column(name="confirmedAt")
    private Timestamp confirmedAt;
    @Column(name="email")
    private String email;

}
