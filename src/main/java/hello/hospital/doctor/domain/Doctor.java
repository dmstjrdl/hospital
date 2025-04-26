package hello.hospital.doctor.domain;

import hello.hospital.availabletime.domain.AvailableTime;
import hello.hospital.department.domain.Department;
import hello.hospital.hospital.domain.Hospital;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

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

    @OneToMany(mappedBy = "doctor")
    private List<AvailableTime> availableTimes;

    private String loginId;
    private String password;
}
