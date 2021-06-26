package VConnect.Aggregator.Implementation;

import VConnect.Aggregator.AuthAggregator;
import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Model.Auth.UserData;
import VConnect.Response.Auth.AuthResponse;
import VConnect.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthAggregatorImpl implements AuthAggregator {
    @Autowired
    UserRepository userRepository;
    public AuthResponse getUserDetails(String email,String password){
        UserData userData = userRepository.getOne(email);
        AuthResponse authResponse = new AuthResponse();
        if(userData!=null && userData.getPassword().equals(password))
        {
            authResponse.setEmail(userData.getEmail());
            authResponse.setUsername(userData.getUsername());
            authResponse.setLogged(true);
            authResponse.setText("You have successfully logged in");
        }
        else
        {
            authResponse.setLogged(false);
            authResponse.setText("Invalid username and password");
        }
        return authResponse;
    }
    public  AuthResponse registerUser(SignUpRequest signUpRequest) {
        Boolean userExists = userRepository.existsById(signUpRequest.getUseremail());
        if(userExists) {
            return new AuthResponse(null,null,null,"This User is already registered");
        }
        UserData userData = new UserData(signUpRequest.getUsername(),signUpRequest.getUseremail(),signUpRequest.getPassword());
        try {
            userRepository.save(userData);
            return new AuthResponse(null,null,null,"User is registered successfully");
        }
        catch (Exception e) {
          return new AuthResponse(null,null,null,"Failed")  ;
        }
    }
    @Override
    public AuthResponse deleteUser(String email) {
        userRepository.deleteById(email);
        return new AuthResponse(null,null,false,"Your account is deleted successfully");
    }
}
