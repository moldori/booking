package hu.flow.booking.services;

import com.fasterxml.jackson.annotation.OptBoolean;
import hu.flow.booking.models.Hotel;
import hu.flow.booking.models.User;
import hu.flow.booking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    public Long getCurrentHotelId() {
        return getCurrentUser().map(User::getHotel).map(Hotel::getId).orElse(-1L);
    }

    public User getCurrentUserIfExist() {
        return getCurrentUser().orElse(null);
    }

    public Optional<User> getCurrentUser() {
        return userRepository.findFirstByUsername(getUsername());
    }

    private String getUsername() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal).map(Object::toString).orElse("");
    }
}
