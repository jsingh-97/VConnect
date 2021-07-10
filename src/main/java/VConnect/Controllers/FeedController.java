package VConnect.Controllers;

import VConnect.Aggregator.Request.PostFeedRequest;
import VConnect.Aggregator.Response.Feed.PostFeedResponse;
import VConnect.Aggregator.Service.PostFeedAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {
    @Autowired
    PostFeedAggregator postFeedAggregator;
    @PostMapping(value = "/user/feed")
    public PostFeedResponse postFeed(@RequestBody PostFeedRequest postFeedRequest){
    return postFeedAggregator.postFeed(postFeedRequest);
    }
}
