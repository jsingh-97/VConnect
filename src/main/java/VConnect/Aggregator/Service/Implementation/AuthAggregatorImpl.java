package VConnect.Aggregator.Service.Implementation;

import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Aggregator.Service.AuthAggregator;
import VConnect.Model.Auth.UserData;
import VConnect.Aggregator.Response.Auth.AuthResponse;
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
            authResponse.addDetails(userData);
            authResponse.setIsLogged(true);
            authResponse.setText("You have successfully logged in");
        }
        else
        {
            authResponse.setIsLogged(false);
            authResponse.setText("Invalid username and password");
        }
        return authResponse;
    }
    public  AuthResponse registerUser(SignUpRequest signUpRequest) {
        Boolean userExists = userRepository.existsById(signUpRequest.getEmail());
        if(userExists) {
            return new AuthResponse("This User is already registered");
        }
        UserData userData = new UserData(signUpRequest.getName(), signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getPhone(), signUpRequest.getDesignation(), signUpRequest.getCity(), signUpRequest.getCompany(), signUpRequest.getSchool(), signUpRequest.getCourse());
        try {
            userRepository.save(userData);
            return new AuthResponse("User is registered successfully");
        }
        catch (Exception e) {
          return new AuthResponse("User registration failed Error : "+e.getMessage())  ;
        }
    }
    @Override
    public AuthResponse deleteUser(String email) {
        userRepository.deleteById(email);
        return new AuthResponse("Your account is deleted successfully");
    }
}
