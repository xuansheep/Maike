package com.john.order.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.john.order.dao.UserRepository;
import com.john.order.domain.dto.UserDTO;
import com.john.order.domain.enums.ExceptionEnum;
import com.john.order.domain.result.CustomException;
import com.john.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private UserRepository userRepository;

    /**
     * 保存用户
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUser(UserDTO user){
        String s = DigestUtil.md5Hex(user.getPassword());
        user.setPassword(s);
        userRepository.save(user);
    }

    /**
     * 登陆
     * @param username
     * @param password
     */
    @Override
    public boolean login(String username, String password){
        UserDTO user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(DigestUtil.md5Hex(password))){
            throw new CustomException(ExceptionEnum.LOGIN_PASSWORD_ERROR);
        }
        return true;
    }
}
