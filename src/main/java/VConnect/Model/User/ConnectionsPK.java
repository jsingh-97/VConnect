package VConnect.Model.User;

import java.io.Serializable;
import java.sql.Timestamp;

public class ConnectionsPK implements Serializable {
    private String follower;
    private String followee;

    public ConnectionsPK(String follower, String followee) {
        this.follower = follower;
        this.followee = followee;
    }

    public ConnectionsPK() {
    }
}
