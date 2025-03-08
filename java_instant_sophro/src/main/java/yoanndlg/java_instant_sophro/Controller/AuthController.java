package yoanndlg.java_instant_sophro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoanndlg.java_instant_sophro.DTOs.UserDTO;
import yoanndlg.java_instant_sophro.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }
}