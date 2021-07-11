package VConnect.Aggregator.Service;

import VConnect.Aggregator.Request.PostFeedRequest;
import VConnect.Aggregator.Response.Feed.PostFeedResponse;

import VConnect.Model.Feed.Feed;

import java.util.List;

public interface FeedAggregator {
    public PostFeedResponse postFeed(PostFeedRequest postFeedRequest);

    List<Feed> getUserFeed(String email);
}
