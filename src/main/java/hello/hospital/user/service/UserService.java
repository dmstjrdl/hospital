package hello.hospital.user.service;

import hello.hospital.user.domain.User;
import hello.hospital.user.dto.RegisterDTO;

public interface UserService {

    User getUserById(Long id);

    void createUser(RegisterDTO registerDTO);
}
