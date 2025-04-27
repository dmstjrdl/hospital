package hello.hospital.medicalrecord.domain;

import hello.hospital.appointment.domain.Appointment;
import hello.hospital.doctor.domain.Doctor;
import hello.hospital.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicalrecord_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private String symptoms;    //  증상
    private String diagnosis;   //  진단
    private String prescription;    //  처방

    @CreationTimestamp
    private LocalDateTime createdAt;
}
