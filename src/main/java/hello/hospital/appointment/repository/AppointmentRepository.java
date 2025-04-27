package hello.hospital.appointment.repository;

import hello.hospital.appointment.domain.Appointment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentDate(Long doctorId,LocalDateTime appointmentDate);

    @EntityGraph(attributePaths = {"user", "doctor"})
    List<Appointment> findByUserId(Long userId);
}
