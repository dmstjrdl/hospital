package hello.hospital.user.service;

import hello.hospital.user.domain.User;
import hello.hospital.user.dto.RegisterDTO;
import hello.hospital.user.dto.ResponseInfoUserDTO;

public interface UserService {

    User getUserById(Long id);

    ResponseInfoUserDTO createUser(RegisterDTO registerDTO);
}
