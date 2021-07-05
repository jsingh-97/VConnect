package VConnect.Aggregator.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter@Setter@AllArgsConstructor
public class ConnectionRequest {
    @JsonProperty(value="follower")
    private String follower;
    @JsonProperty(value="followee")
    private String followee;
    @JsonProperty(value = "timestamp")
    private Timestamp timestamp;
}
