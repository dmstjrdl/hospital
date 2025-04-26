package hello.hospital.availabletime.dto;

import hello.hospital.availabletime.domain.AvailableTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class ResponseInfoAvailableTime {

    private String doctorName;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public static ResponseInfoAvailableTime from(AvailableTime availableTime) {
        return new ResponseInfoAvailableTime(
                availableTime.getDoctor().getName(),
                availableTime.getDayOfWeek(),
                availableTime.getStartTime(),
                availableTime.getEndTime()
        );
    }
}
