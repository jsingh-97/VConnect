package VConnect.Aggregator.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter@Setter@AllArgsConstructor
public class PostFeedRequest {
    @JsonProperty("email")
    private String email;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("company")
    private String company;
    @JsonProperty("minexp")
    private Integer minExp;
    @JsonProperty("maxexp")
    private Integer maxExp;
    private String city;
    private String description;
    private Timestamp timestamp;
    @JsonProperty("metadata")
    private String metaData;
    public PostFeedRequest() {
    }

}
