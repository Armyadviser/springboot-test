package storm_falcon.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import storm_falcon.demo.domain.User;
import storm_falcon.demo.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gewp
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model,
                           @ModelAttribute(value = "user") User user,
                           HttpServletResponse response) {
        String result = userService.register(user);
        model.addAttribute("result", result);
        return response.encodeRedirectURL("/index");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,
                        @ModelAttribute(value = "user") User user,
                        HttpServletResponse response,
                        HttpSession session) {
        String result = userService.login(user);
        if ("登录成功".equals(result)) {
            session.setAttribute("user", user);
        }
        model.addAttribute("result", result);
        return response.encodeRedirectURL("/index");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }
}
