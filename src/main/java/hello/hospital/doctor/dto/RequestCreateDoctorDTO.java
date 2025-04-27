package hello.hospital.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestCreateDoctorDTO {

    private Long userId;
    private Long hospitalId;
    private Long departmentId;
}
