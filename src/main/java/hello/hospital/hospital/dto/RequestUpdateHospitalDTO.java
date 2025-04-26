package hello.hospital.hospital.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestUpdateHospitalDTO {

    @NotBlank(message = "병원명을 입력해주세요.")
    private String hospitalName;

    @NotBlank(message = "주소를 입력해주세요.")
    private String hospitalAddress;

}
