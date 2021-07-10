package VConnect.Aggregator.Service.Implementation;

import VConnect.Aggregator.Request.ConnectionRequest;
import VConnect.Aggregator.Service.ConnectionsAggregator;
import VConnect.Model.User.Connections;
import VConnect.Aggregator.Response.Connections.ConnectionsResponse;
import VConnect.Respository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionsAggregatorImpl implements ConnectionsAggregator {

    @Autowired
    ConnectionsRepository connectionsRepository;

    @Override
    public List<String> getFollowers(String email) {
        return connectionsRepository.findByEmail(email);
    }

    @Override
    public ConnectionsResponse followUser(ConnectionRequest connectionRequest) {
        ConnectionsResponse connectionsResponse=new ConnectionsResponse();
        Connections connection = new Connections(connectionRequest.getFollower(),connectionRequest.getFollowee(),connectionRequest.getTimestamp());
        try{
            connectionsRepository.save(connection);
            connectionsResponse.setText("User followed successfully");
        }
        catch (Exception err){
            connectionsResponse.setText("Error occured while following user : "+err);
        }
        return connectionsResponse;
    }

    @Override
    public ConnectionsResponse unFollowUser(ConnectionRequest connectionRequest) {
        ConnectionsResponse connectionsResponse=new ConnectionsResponse();
        Connections connection = new Connections(connectionRequest.getFollower(),connectionRequest.getFollowee(),connectionRequest.getTimestamp());
        try{
            connectionsRepository.delete(connection);
            connectionsResponse.setText("User unfollowed successfully");
        }
        catch (Exception err){
            connectionsResponse.setText("Error occured while unfollowing user : "+err);
        }
        return connectionsResponse;
    }
}
