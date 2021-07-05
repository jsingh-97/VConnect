package VConnect.Aggregator.Service;

import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Response.Auth.AuthResponse;

public interface AuthAggregator {
     AuthResponse getUserDetails(String email,String password);
     AuthResponse registerUser(SignUpRequest signUpRequest);
     AuthResponse deleteUser(String email);
}
