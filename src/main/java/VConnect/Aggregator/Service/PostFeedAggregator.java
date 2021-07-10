package VConnect.Aggregator.Service;

import VConnect.Aggregator.Request.PostFeedRequest;
import VConnect.Aggregator.Response.Feed.PostFeedResponse;

public interface PostFeedAggregator {
    public PostFeedResponse postFeed(PostFeedRequest postFeedRequest);
}
