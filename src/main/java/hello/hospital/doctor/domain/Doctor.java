package hello.hospital.doctor.domain;

import hello.hospital.availabletime.domain.AvailableTime;
import hello.hospital.department.domain.Department;
import hello.hospital.hospital.domain.Hospital;
import hello.hospital.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    @Builder.Default
    private List<AvailableTime> availableTimes = new ArrayList<>();;

}
