package com.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@Scope(value="singleton")  //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
@RequestMapping("/mvc")
public class mvcController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public String hello(){

        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, UserDto userDto){
        System.out.println(userDto.getUserName());
        System.out.println(userDto.getPassWord());

        model.addAttribute("userName",userDto.getUserName());
        model.addAttribute("passWord",userDto.getPassWord());

        userDao.save();

        return "welcome";
    }
}

