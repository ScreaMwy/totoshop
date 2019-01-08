package org.totoshop.web;

import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import org.totoshop.pojo.User;
import org.totoshop.service.UserService;
import org.totoshop.util.multipart.FileTransfer;

@Controller("userController")
@Scope(scopeName = "singleton")
@RequestMapping(path = {"/user", "/user/"})
public class UserController {
    @Resource(name = "fileTransfer", type = FileTransfer.class)
    private FileTransfer fileTransfer;

    private Map<String, Object> modelMap;

    private User user;

    @Resource(name = "userService", type = UserService.class)
    private UserService userService;

    @RequestMapping(path = {"/main", "/main/"}, method = {RequestMethod.POST, RequestMethod.GET})
    private String userMain() {
        return "user";
    }

    @RequestMapping(path = {"/userShow"}, method = {RequestMethod.POST, RequestMethod.GET})
    private String showUser() {
        return "show";
    }

    @RequestMapping(path = {"/login"}, method = {RequestMethod.POST})
    @ResponseBody
    private Map<String, Object> userLogin(@RequestParam(name = "username", required = false) String userid, @RequestParam(name = "password", required = false) String password, HttpServletRequest request) {
        user = userService.findUser(userid, password);
        modelMap = new HashMap<String, Object>();
        if (null != user) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getuName());
            modelMap.put("user", user);
        } else {
            modelMap.put("error", 204);
        }
        return modelMap;
    }
}

