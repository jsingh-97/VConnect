package VConnect.Aggregator.Service.Implementation;

import VConnect.Aggregator.Request.PostFeedRequest;
import VConnect.Aggregator.Response.Feed.PostFeedResponse;
import VConnect.Aggregator.Service.PostFeedAggregator;
import VConnect.Model.Feed.Feed;
import VConnect.Respository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostFeedAggregatorImpl implements PostFeedAggregator {
    @Autowired
    FeedRepository feedRepository;
    @Override
    public PostFeedResponse postFeed(PostFeedRequest postFeedRequest) {
    Feed feed= new Feed(postFeedRequest);
    try {
        feedRepository.save(feed);
    }catch (Exception e){
        System.out.println("An error occured: "+e);
    }
    return new PostFeedResponse();
    }
}
