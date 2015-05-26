package com.baidu.pikaq.demo.web.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by knightliao on 15/1/20.
 */
@Controller
@RequestMapping("/home")
public class FreeMarkerController {

    public static class User {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @RequestMapping("/index")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("1234");
        List<User> users = new ArrayList<User>();
        users.add(user);
        return new ModelAndView("index", "users", users);
    }
}
