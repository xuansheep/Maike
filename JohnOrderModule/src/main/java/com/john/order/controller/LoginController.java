package com.john.order.controller;

import com.john.order.domain.result.Result;
import com.john.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * order统一登陆入口
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/apply" , method = { RequestMethod.POST, RequestMethod.GET})
    public Result apply(String username, String password){
        boolean result = userService.login(username, password);
        return Result.success(result);
    }
}
