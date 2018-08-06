package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";


    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/count")
    public @ResponseBody String count() {

        return Long.toString(userRepository.count());

    }

    @PutMapping(path="/user1/{id}") //udpate됨
    public @ResponseBody String updateUser1(@PathVariable Integer id, @RequestBody UserV1 user) {

        String ret = "NotThingToDo";
        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()) {
            User us = u.get();
            us.setEmail(user.getEmail());
            us.setName(user.getName());
            userRepository.save(us);
            ret = "Saved";
        }

        return ret;

    }


    @PutMapping(path="/user2/{id}") //그냥 새로 insert됨
    public @ResponseBody String updateUser2(@PathVariable Integer id, @RequestBody UserV1 user) {

        String ret = "NotThingToDo";
        User u = new User();
        u.setId(id);
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        userRepository.save(u);
        ret = "Saved";


        return ret;

    }
}
