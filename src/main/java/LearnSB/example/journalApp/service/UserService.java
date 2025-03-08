package LearnSB.example.journalApp.service;

import LearnSB.example.journalApp.model.Users;
import LearnSB.example.journalApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepo repo;

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
      return repo.save(user);
    }

}
