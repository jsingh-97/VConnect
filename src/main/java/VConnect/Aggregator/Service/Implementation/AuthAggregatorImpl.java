package VConnect.Aggregator.Service.Implementation;

import VConnect.Aggregator.Request.SignUpRequest;
import VConnect.Aggregator.Service.AuthAggregator;
import VConnect.Model.Auth.ConfirmationToken;
import VConnect.Model.Auth.UserData;
import VConnect.Aggregator.Response.Auth.AuthResponse;
import VConnect.Respository.ConfirmationTokenRepository;
import VConnect.Respository.Service.ConfirmationTokenService;
import VConnect.Respository.Service.UserService;
import VConnect.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class AuthAggregatorImpl implements AuthAggregator {
    @Autowired
    UserService userService;
    @Autowired
    ConfirmationTokenService confirmationTokenService;
    public AuthResponse getUserDetails(String email,String password){
        UserData userData = userService.findByEmail(email);
        AuthResponse authResponse = new AuthResponse();
        if(userData==null ||  !userData.getPassword().equals(password))
        {
            authResponse.setIsLogged(false);
            authResponse.setText("Invalid username and password");
            return authResponse;
        }
        if(userData.getEnabled()==false) {
            authResponse.setIsLogged(false);
            authResponse.setText("Please verify your email to complete registration process or try registering again if the link has expired");
        }
        else{
            authResponse.setIsLogged(true);
            authResponse.setText("Welcome");
        }
        return authResponse;
    }
    public  AuthResponse registerUser(SignUpRequest signUpRequest) {
        Boolean userExists = userService.emailExists(signUpRequest.getEmail());
        if(userExists) {
            return new AuthResponse("This User is already registered. Check your email to verify the registration");
        }
        UserData userData = new UserData(signUpRequest.getName(), signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getPhone(), signUpRequest.getDesignation(), signUpRequest.getCity(), signUpRequest.getCompany(), signUpRequest.getSchool(), signUpRequest.getCourse(),false);
        try {
            userService.registerUser(userData);
            String token = UUID.randomUUID().toString();
            //generating token for session
            ConfirmationToken confirmationToken=new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(2),null,signUpRequest.getEmail());
            confirmationTokenService.addToken(confirmationToken);
            //sending email to user
            return new AuthResponse("Please verify your email address to complete the registration process");
        }
        catch (Exception e) {
          return new AuthResponse("User registration failed Error : "+e.getMessage())  ;
        }
    }
    @Override
    public AuthResponse deleteUser(String email) {
        userService.deleteByEmail(email);
        return new AuthResponse("Your account is deleted successfully");
    }

    @Override
    public String confirmToken(String token) {
        try{
            ConfirmationToken confirmationToken = confirmationTokenService.getToken(token);
            if(confirmationToken==null)
                return "Token not found.Try registering again";
            if(confirmationToken.getConfirmedAt()!=null)
                return "Email is already verified";
            if(confirmationToken.getExpiresAt().isBefore(LocalDateTime.now()))
                return "This link is expired.Try registering again";
            confirmationTokenService.setConfirmedAt(token);
            userService.verifyUser(confirmationToken.getEmail());
            return "confirmed";

        }catch (Exception e){
        return "Exception occured  err: "+e;
        }

    }
}
