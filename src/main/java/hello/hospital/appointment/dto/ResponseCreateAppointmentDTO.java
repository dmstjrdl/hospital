package hello.hospital.appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.hospital.appointment.domain.Appointment;
import hello.hospital.appointment.domain.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ResponseCreateAppointmentDTO {

    private Long id;
    private Long userId;
    private String userName;
    private Long hospitalId;
    private String hospitalName;
    private String department;
    private Long doctorId;
    private String doctorName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime appointmentTime;

    private AppointmentStatus appointmentStatus;

    public static ResponseCreateAppointmentDTO from(Appointment appointment) {
        return new ResponseCreateAppointmentDTO(
                appointment.getId(),
                appointment.getUser().getId(),
                appointment.getUser().getName(),
                appointment.getHospital().getId(),
                appointment.getHospital().getName(),
                appointment.getDoctor().getDepartment().getName(),
                appointment.getDoctor().getId(),
                appointment.getDoctor().getName(),
                appointment.getAppointmentDate(),
                appointment.getStatus()
        );
    }
}
