package hello.hospital.hospital.repository;

import hello.hospital.hospital.domain.Hospital;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    @EntityGraph(attributePaths = "departments")
    List<Hospital> findAll();

    List<Hospital> findByNameContaining(String hospitalName);
}
