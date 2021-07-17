package VConnect.Model.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


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
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="expires_at")
    private LocalDateTime expiresAt;
    @Column(name="confirmed_at")
    private LocalDateTime confirmedAt;
    @Column(name="email")
    private String email;
   public ConfirmationToken(String token,LocalDateTime createdAt,LocalDateTime expiresAt,LocalDateTime confirmedAt,String email){
        this.token=token;
        this.createdAt=createdAt;
        this.expiresAt=expiresAt;
        this.confirmedAt=confirmedAt;
        this.email=email;
   }
}
