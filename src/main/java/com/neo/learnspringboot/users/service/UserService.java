package com.neo.learnspringboot.users.service;


import com.neo.learnspringboot.users.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserEntity getDummyUser (){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setFirstName("Yosef");
        user.setLastName("Yosef");
        user.setEmail("Yosef");

        return  user;
    }

}
