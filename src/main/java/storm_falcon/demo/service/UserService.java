package storm_falcon.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storm_falcon.demo.domain.User;
import storm_falcon.demo.domain.UserRepository;

/**
 * @author gewp
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser == null) {
            userRepository.save(user);
            return "注册成功";
        }
        return "用户名已存在";
    }

    public String login(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser == null) {
            return "该用户不存在";
        }

        if (!dbUser.getPassword().equals(user.getPassword())) {
            return "密码错误";
        }

        user.setId(dbUser.getId());
        user.setStatus(dbUser.getStatus());
        return "登录成功";
    }

}
