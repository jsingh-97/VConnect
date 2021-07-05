package VConnect.Model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name= "connections")
@IdClass(ConnectionsPK.class)
@Getter
@Setter
@AllArgsConstructor
public class Connections {
    @Id
    @Column(name="follower")
    private String follower;
    @Id
    @Column(name="followee")
    private String followee;
    @Column(name="timestamp")
    private Timestamp timestamp;
    public Connections(){

    }
}
