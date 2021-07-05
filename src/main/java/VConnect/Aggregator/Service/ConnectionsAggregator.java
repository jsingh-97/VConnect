package VConnect.Aggregator.Service;

import VConnect.Aggregator.Request.ConnectionRequest;
import VConnect.Response.Connections.ConnectionsResponse;

public interface ConnectionsAggregator {
    ConnectionsResponse followUser(ConnectionRequest connectionRequest);
    ConnectionsResponse unFollowUser(ConnectionRequest connectionRequest);

}
