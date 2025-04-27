package hello.hospital.appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.hospital.appointment.domain.Appointment;
import hello.hospital.appointment.domain.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ResponseInfoAppointmentDTO {

    private Long id;
    private String hospitalName;
    private String departmentName;
    private String doctorName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;

    public static ResponseInfoAppointmentDTO from(Appointment appointment) {
        return new ResponseInfoAppointmentDTO(
                appointment.getId(),
                appointment.getHospital().getName(),
                appointment.getDoctor().getDepartment().getName(),
                appointment.getDoctor().getUser().getName(),
                appointment.getAppointmentDate(),
                appointment.getStatus()
        );
    }
}
