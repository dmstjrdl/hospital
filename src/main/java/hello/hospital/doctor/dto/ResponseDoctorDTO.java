package hello.hospital.doctor.dto;

import hello.hospital.doctor.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor

public class ResponseDoctorDTO {
    private List<ResponseInfoDoctorDTO> doctors;

    public static ResponseDoctorDTO from(List<Doctor> doctors) {
        List<ResponseInfoDoctorDTO> result = doctors.stream()
                .map(ResponseInfoDoctorDTO::from)
                .toList();

        return new ResponseDoctorDTO(result);
    }
}
