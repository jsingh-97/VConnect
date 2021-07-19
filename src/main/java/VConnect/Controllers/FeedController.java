package VConnect.Controllers;

import VConnect.Aggregator.Request.PostFeedRequest;
import VConnect.Aggregator.Response.Feed.PostFeedResponse;
import VConnect.Aggregator.Service.FeedAggregator;
import VConnect.Model.Feed.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FeedController {
    @Autowired
    FeedAggregator feedAggregator;
    @PostMapping(value = "/user/feed")
    public PostFeedResponse postFeed(@RequestBody PostFeedRequest postFeedRequest){
    return feedAggregator.postFeed(postFeedRequest);
    }
    @GetMapping(value = "/user/feed")
    public List<Feed> getFeed(@RequestParam String email){
        return feedAggregator.getUserFeed(email);
    }
}
