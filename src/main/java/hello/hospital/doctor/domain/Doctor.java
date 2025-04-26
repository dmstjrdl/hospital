package hello.hospital.doctor.domain;

import hello.hospital.department.domain.Department;
import hello.hospital.hospital.domain.Hospital;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private String loginId;
    private String password;
}
