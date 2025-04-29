package hello.hospital.availabletime.repository;

import hello.hospital.availabletime.domain.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {
    boolean existsByDoctorIdAndDayOfWeek(Long doctorId, DayOfWeek dayOfWeek);
}
