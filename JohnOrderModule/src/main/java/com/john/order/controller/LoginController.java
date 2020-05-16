package com.john.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * order统一登陆入口
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @RequestMapping(value = "/apply" , method = { RequestMethod.POST})
    public String apply(){

        return "success";
    }
}
