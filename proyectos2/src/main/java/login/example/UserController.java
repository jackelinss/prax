package login.example;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.UserRepository;
import entity.Usuario;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/public/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getNombreUsuario()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }

        // Hash the password before storing it
        user.setContrasena(bCryptPasswordEncoder.encode(user.getContrasena()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping("/public/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login successful.");
    }
}