package VConnect.Respository.Service;

import VConnect.Model.Auth.UserData;
import VConnect.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserData findByEmail(String email) {
        return userRepository.getOne(email);
    }

    public Boolean emailExists(String email) {
        return userRepository.existsById(email);
    }

    public void registerUser(UserData userData) {
        userRepository.save(userData);
    }

    public void deleteByEmail(String email) {
        userRepository.deleteById(email);
    }

    public void verifyUser(String email) {
        userRepository.verifyUser(email);
    }
}
