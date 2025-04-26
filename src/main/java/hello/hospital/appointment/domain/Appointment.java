package hello.hospital.appointment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.hospital.doctor.domain.Doctor;
import hello.hospital.hospital.domain.Hospital;
import hello.hospital.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public Appointment(User user, Doctor doctor, Hospital hospital, LocalDateTime appointmentDate, AppointmentStatus status) {
        this.user = user;
        this.doctor = doctor;
        this.hospital = hospital;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
}
