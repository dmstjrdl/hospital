package hello.hospital.user.service;

import hello.hospital.exception.UserAlreadyExists;
import hello.hospital.exception.UserNotFound;
import hello.hospital.user.domain.Role;
import hello.hospital.user.domain.User;
import hello.hospital.user.dto.RegisterDTO;
import hello.hospital.user.dto.ResponseInfoUserDTO;
import hello.hospital.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFound::new);
    }

    @Override
    public ResponseInfoUserDTO createUser(RegisterDTO registerDTO) {
        boolean exist = existLoginId(registerDTO.getLoginId());
        if (exist) throw new UserAlreadyExists();

        User user = User.builder()
                .loginId(registerDTO.getLoginId())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .name(registerDTO.getName())
                .birthday(registerDTO.getBirthday())
                .phone(registerDTO.getPhone())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return ResponseInfoUserDTO.from(user);
    }

    public boolean existLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }
}
