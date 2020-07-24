import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ZHZ
 */
@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String phone,
                                           @RequestParam String password,
                                           User user){
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        userRepository.save(user);
        log.info(user.toString()+" save to the repo");
        return "Saved";
    }
    @GetMapping(path="/login")
    public String login(@RequestParam String phone, @RequestParam String password, Model model) {
        List<User> users = userRepository.findByPhone(phone);
        //如果没有find到该账号
        User user = null;
        if (user == null) {
            log.warn("non-existed account");
            return "用户不存在";
        } else {
            user = users.get(0);
            if (user.getPassword().equals(password)) {
                // 如果密码与邮箱配对成功:
                model.addAttribute("name", user.getName());
                log.warn(user.toString() + " logged in");
            } else {
                // 如果密码与邮箱不匹配:
                model.addAttribute("name", "logging failed");
                log.warn(user.toString() + " failed to log in");
            }
            return "index";
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
    }
    @GetMapping(path="/")
    public String welcomePage(@RequestParam(name="name", required=false, defaultValue="World")
                                      String name){
        return "index";
    }
}
