package com.example.UserModule.Service;

import com.example.UserModule.Entity.UserModule;
import com.example.UserModule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

 //   @Override
//    public ResponseEntity<LoginResponseDTO> login(String username, String password) {
//        List<User> userList=(List<User>)userRepository.findAll();
//        LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
//        for(User user:userList){
//            if(username.equals(user.getEmailId()) && password.equals(user.getPassword())){
//                loginResponseDTO.setHttpStatus(HttpStatus.OK);
//                loginResponseDTO.setUid(user.getUserId());
//                return ResponseEntity.accepted().body(loginResponseDTO);
//            }
//        }
//        loginResponseDTO.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
//        return ResponseEntity.accepted().body(loginResponseDTO);
//    }

    @Override
    public  Boolean signup(UserModule user) {

        userRepository.save(user);
        return true;
    }


}
