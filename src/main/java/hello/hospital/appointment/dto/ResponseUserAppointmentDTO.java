package hello.hospital.appointment.dto;

import hello.hospital.appointment.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseUserAppointmentDTO {

    private List<ResponseInfoAppointmentDTO> appointments;

    public static ResponseUserAppointmentDTO from(List<Appointment> appointments) {
        List<ResponseInfoAppointmentDTO> result = appointments.stream()
                .map(ResponseInfoAppointmentDTO::from)
                .toList();

        return new ResponseUserAppointmentDTO(result);
    }
}
