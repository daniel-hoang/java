package derby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DerbyController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    User home(User user) {
        user = userService.create(user);
        return user;
    }

    @RequestMapping("/users")
    List<User> findAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }
}
