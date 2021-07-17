package VConnect.Aggregator.Service.Implementation;

import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Aggregator.Service.AuthAggregator;
import VConnect.Model.Auth.ConfirmationToken;
import VConnect.Model.Auth.UserData;
import VConnect.Aggregator.Response.Auth.AuthResponse;
import VConnect.Respository.ConfirmationTokenRepository;
import VConnect.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class AuthAggregatorImpl implements AuthAggregator {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;
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
            String token = UUID.randomUUID().toString();
            //generating token for session
            ConfirmationToken confirmationToken=new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(2),null,signUpRequest.getEmail());
            confirmationTokenRepository.save(confirmationToken);
            //sending email to user
            return new AuthResponse("Please verify your email address to complete the registration process");
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
