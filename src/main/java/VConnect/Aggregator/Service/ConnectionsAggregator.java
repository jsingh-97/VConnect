package VConnect.Aggregator.Service;

import VConnect.Aggregator.Request.ConnectionRequest;
import VConnect.Aggregator.Response.Connections.ConnectionsResponse;

import java.util.List;

public interface ConnectionsAggregator {
     List<String> getFollowers(String email);

    ConnectionsResponse followUser(ConnectionRequest connectionRequest);
    ConnectionsResponse unFollowUser(ConnectionRequest connectionRequest);

}
