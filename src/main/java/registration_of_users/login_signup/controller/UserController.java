package registration_of_users.login_signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import registration_of_users.login_signup.dto.UserLoginDTO;
import registration_of_users.login_signup.dto.UserSignupDTO;
import registration_of_users.login_signup.model.User;
import registration_of_users.login_signup.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/signup")
    public User registerUser(@RequestBody UserSignupDTO userSignupDTO) {
        User user = new User();
        user.setFirstname(userSignupDTO.getFirstname());
        user.setLastname(userSignupDTO.getLastname());
        user.setEmail(userSignupDTO.getEmail());
        user.setUsername(userSignupDTO.getUsername());
        user.setUsertype(userSignupDTO.getUsertype());
        user.setPassword(userSignupDTO.getPassword());
        return userService.registerNewUser(user);
    }

    /**
     *
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        boolean isAuthenticated = userService.authenticate(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if (isAuthenticated) {
            User user = userService.findByUsername(userLoginDTO.getUsername());
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");

        }
    }

    @GetMapping("/userdetails")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

}
