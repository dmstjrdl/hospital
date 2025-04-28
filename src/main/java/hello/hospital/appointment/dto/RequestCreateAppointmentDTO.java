package hello.hospital.appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RequestCreateAppointmentDTO {

    @NotNull(message = "의사는 반드시 선택되어야 합니다.")
    private Long doctorId;

    @NotNull(message = "병원은 반드시 선택되어야 합니다.")
    private Long hospitalId;

    @Future(message = "예약시간이 잘못되었습니다.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
}
