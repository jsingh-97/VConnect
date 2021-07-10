package VConnect.Model.Feed;

import VConnect.Aggregator.Request.PostFeedRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="userfeed")
@Getter@Setter@AllArgsConstructor
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="email")
    private String email;
    @Column(name="designation")
    private String designation;
    @Column(name="company")
    private String company;
    @Column(name= "minexp")
    private Integer minExp;
    @Column(name="maxexp")
    private Integer maxExp;
    @Column(name="city")
    private String city;
    @Column(name="description")
    private String description;
    @Column(name="timestamp")
    private Timestamp timestamp;


    public Feed(PostFeedRequest postFeedRequest) {
    email=postFeedRequest.getEmail();
    designation=postFeedRequest.getDesignation();
    company=postFeedRequest.getCompany();
    minExp=postFeedRequest.getMinExp();
    maxExp=postFeedRequest.getMaxExp();
    city=postFeedRequest.getCity();
    description=postFeedRequest.getDescription();
    timestamp=postFeedRequest.getTimestamp();
    }
}
