package hello.hospital.user.dto;

import hello.hospital.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseInfoUserDTO {

    private String loginId;
    private String name;
    private String birthday;
    private String phone;

    public static ResponseInfoUserDTO from(User user) {
        return new ResponseInfoUserDTO(
                user.getLoginId(),
                user.getName(),
                user.getBirthday(),
                user.getPhone()
        );
    }
}
