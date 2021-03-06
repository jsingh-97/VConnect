package VConnect.Controllers;

import VConnect.Aggregator.Service.AuthAggregator;
import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Aggregator.Response.Auth.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthAggregator authAggregator;
    @GetMapping("/")
    public String healthCheck(){
        return "Welcome to VConnect";
    }

    @GetMapping("/auth/user")
    public AuthResponse getUserDetails(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password){
        return authAggregator.getUserDetails(email,password);
    }

    @PostMapping("/auth/user")
    public AuthResponse registerUser(
            @RequestBody SignUpRequest signUpRequest){
        return authAggregator.registerUser(signUpRequest);
    }
    @DeleteMapping("/auth/user")
    public AuthResponse registerUser(
            @RequestParam(value = "email", required = true) String email){
        return authAggregator.deleteUser(email);
    }
    @GetMapping("/auth/user/confirmToken")
    public String confirmToken(@RequestParam("token") String token){
        return authAggregator.confirmToken(token);
    }
}
