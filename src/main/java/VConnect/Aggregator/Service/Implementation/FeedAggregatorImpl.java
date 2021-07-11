package VConnect.Aggregator.Service.Implementation;

import VConnect.Aggregator.Request.PostFeedRequest;
import VConnect.Aggregator.Response.Feed.PostFeedResponse;
import VConnect.Aggregator.Service.FeedAggregator;
import VConnect.Model.Feed.Feed;
import VConnect.Respository.ConnectionsRepository;
import VConnect.Respository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FeedAggregatorImpl implements FeedAggregator {
    @Autowired
    FeedRepository feedRepository;
    @Autowired
    ConnectionsRepository connectionsRepository;
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

    @Override
    public List<Feed> getUserFeed(String email) {
        List<String> followee = connectionsRepository.findFollowee(email);
        if(!followee.isEmpty()){
            return feedRepository.findByEmail(followee);
        }
        return Arrays.asList(new Feed());
    }
}
