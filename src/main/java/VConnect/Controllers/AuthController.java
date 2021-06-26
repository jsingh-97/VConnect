package VConnect.Controllers;

import VConnect.Aggregator.AuthAggregator;
import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Response.Auth.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthAggregator authAggregator;
    @GetMapping("/")
    public String healthCheck(){
        return "ok";
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
}
