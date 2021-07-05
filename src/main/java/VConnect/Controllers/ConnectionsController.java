package VConnect.Controllers;

import VConnect.Aggregator.Request.ConnectionRequest;
import VConnect.Aggregator.Service.ConnectionsAggregator;
import VConnect.Response.Connections.ConnectionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConnectionsController {
    @Autowired
    ConnectionsAggregator connectionsAggregator;
    @PostMapping("user/follow")
    public ConnectionsResponse followUser(@RequestBody ConnectionRequest connectionRequest){
    return connectionsAggregator.followUser(connectionRequest);
    }
    @DeleteMapping("user/follow")
    public ConnectionsResponse unFollowUser(@RequestBody ConnectionRequest connectionRequest){
        return connectionsAggregator.unFollowUser(connectionRequest);
    }
}
