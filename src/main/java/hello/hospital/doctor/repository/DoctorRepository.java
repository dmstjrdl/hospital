package hello.hospital.doctor.repository;

import hello.hospital.doctor.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
