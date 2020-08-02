package com.gordon.petStore.service;

import com.gordon.petStore.model.UserEO;
import com.gordon.petStore.repository.UserRepository;
import com.gordon.petStore.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 19:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void signIn(UserRequest userRequest) {

        //TODO need to confirm repo have no this user first

        UserEO userEO = new UserEO();
        userEO.setName(userRequest.getPassword());

        //TODO encrypt password
        userEO.setPassword(userRequest.getPassword());
        userRepository.save(userEO);

    }
}
