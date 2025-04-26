package hello.hospital.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginDTO {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

}
