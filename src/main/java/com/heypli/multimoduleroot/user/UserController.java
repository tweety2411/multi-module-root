package com.heypli.multimoduleroot.user;

import com.heypli.repo.domain.User;
import com.heypli.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUSer(@RequestBody User user) throws  Exception{
        User savedUser = userService.setUser(user);
        User saved = userService.getUser(savedUser.getId());
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

}
