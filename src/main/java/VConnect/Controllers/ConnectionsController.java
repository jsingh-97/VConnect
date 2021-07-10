package VConnect.Controllers;

import VConnect.Aggregator.Request.ConnectionRequest;
import VConnect.Aggregator.Service.ConnectionsAggregator;
import VConnect.Aggregator.Response.Connections.ConnectionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectionsController {
    @Autowired
    ConnectionsAggregator connectionsAggregator;
    @GetMapping("user/follow")
    public List<String> getFollowers(@RequestParam String email){
        return connectionsAggregator.getFollowers(email);
    }
    @PostMapping("user/follow")
    public ConnectionsResponse followUser(@RequestBody ConnectionRequest connectionRequest){
    return connectionsAggregator.followUser(connectionRequest);
    }
    @DeleteMapping("user/follow")
    public ConnectionsResponse unFollowUser(@RequestBody ConnectionRequest connectionRequest){
        return connectionsAggregator.unFollowUser(connectionRequest);
    }

}
