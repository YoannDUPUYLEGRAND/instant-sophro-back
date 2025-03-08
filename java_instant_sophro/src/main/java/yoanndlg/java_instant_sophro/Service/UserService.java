package yoanndlg.java_instant_sophro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yoanndlg.java_instant_sophro.DTOs.UserDTO;
import yoanndlg.java_instant_sophro.Models.User;
import yoanndlg.java_instant_sophro.Repository.UserRepository;

import java.util.HashSet;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserDTO userDTO) {
        String role = userDTO.getRole();
        if (role == null || role.isEmpty()) {
            role = "USER";
        }

        User user = new User(userDTO.getEmail(), userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()), new HashSet<>());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}