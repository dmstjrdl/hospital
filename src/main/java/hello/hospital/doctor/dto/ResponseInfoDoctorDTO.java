package hello.hospital.doctor.dto;

import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;
import hello.hospital.doctor.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseInfoDoctorDTO {

    private String doctorName;
    private String hospitalName;
    private String departmentName;
    private List<ResponseInfoAvailableTime> availableTime;

    public static ResponseInfoDoctorDTO from(Doctor doctor) {
        List<ResponseInfoAvailableTime> availableTimes = doctor.getAvailableTimes().stream()
                .map(ResponseInfoAvailableTime::from)
                .toList();

        return new ResponseInfoDoctorDTO(
                doctor.getName(),
                doctor.getHospital().getName(),
                doctor.getDepartment().getName(),
                availableTimes
        );
    }
}
