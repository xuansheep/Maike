package com.john.order.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.john.order.dao.UserRepository;
import com.john.order.domain.dto.UserDTO;
import com.john.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 保存用户
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUser(UserDTO user){
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        userRepository.save(user);
    }
}
