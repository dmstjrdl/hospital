package hello.hospital.doctor.repository;

import hello.hospital.doctor.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByHospitalNameContainingAndDepartmentNameContaining(String hospitalName, String departmentName);
    List<Doctor> findByHospitalNameContaining(String hospitalName);
    List<Doctor> findByDepartmentNameContaining(String departmentName);
}
