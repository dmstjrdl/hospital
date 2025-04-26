package hello.hospital.hospital.dto;

import hello.hospital.appointment.dto.ResponseInfoAppointmentDTO;
import hello.hospital.appointment.dto.ResponseUserAppointmentDTO;
import hello.hospital.hospital.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseHospitalDTO {

    private List<ResponseInfoHospitalDTO> hospitals;

    public static ResponseHospitalDTO from(List<Hospital> hospitals) {
        List<ResponseInfoHospitalDTO> result = hospitals.stream()
                .map(ResponseInfoHospitalDTO::from)
                .toList();

        return new ResponseHospitalDTO(result);
    }
}
