package hello.hospital.user.service;

import hello.hospital.exception.UserNotFound;
import hello.hospital.user.domain.CustomUserDetails;
import hello.hospital.user.domain.User;
import hello.hospital.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId).orElseThrow(UserNotFound::new);

        return new CustomUserDetails(user);
    }
}
