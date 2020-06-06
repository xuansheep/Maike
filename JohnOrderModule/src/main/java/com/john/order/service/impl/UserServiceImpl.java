package com.john.order.service.impl;

import com.john.order.dao.UserRepository;
import com.john.order.domain.dto.UserDTO;
import com.john.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    void saveUser(UserDTO user){
        userRepository.save(user);
    }
}
