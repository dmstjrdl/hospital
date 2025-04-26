package hello.hospital.medicalrecord.domain;

import hello.hospital.appointment.domain.Appointment;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class MedicalRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicalrecord_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private String symptoms;
    private String diagnosis;
    private String prescription;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
