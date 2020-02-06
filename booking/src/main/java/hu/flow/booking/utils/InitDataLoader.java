package hu.flow.booking.utils;

import hu.flow.booking.models.User;
import hu.flow.booking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class InitDataLoader {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        loadUsers();
    }

    private void loadUsers() {
        userRepository.save(User.builder().username("john").password(passwordEncoder.encode("password")).build());
    }
}
