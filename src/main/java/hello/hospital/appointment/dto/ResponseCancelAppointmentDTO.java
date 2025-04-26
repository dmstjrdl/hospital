package hello.hospital.appointment.dto;

import hello.hospital.appointment.domain.Appointment;
import hello.hospital.appointment.domain.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ResponseCancelAppointmentDTO {

    private Long appointmentId;
    private AppointmentStatus status;
    private LocalDateTime cancelDateTime;
    private String message;

    public static ResponseCancelAppointmentDTO from(Appointment appointment) {
        return new ResponseCancelAppointmentDTO(
                appointment.getId(),
                appointment.getStatus(),
                LocalDateTime.now(),
                "예약이 정상적으로 취소되었습니다."
        );
    }
}
