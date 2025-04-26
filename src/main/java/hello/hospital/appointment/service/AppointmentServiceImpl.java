package hello.hospital.appointment.service;

import hello.hospital.appointment.dto.*;
import hello.hospital.exception.*;
import hello.hospital.appointment.domain.Appointment;
import hello.hospital.appointment.domain.AppointmentStatus;
import hello.hospital.appointment.repository.AppointmentRepository;
import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.service.DoctorService;
import hello.hospital.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserService userService;
    private final DoctorService doctorService;

    @Override
    public ResponseInfoAppointmentDTO infoAppointment(Long appointmentId) {
        return ResponseInfoAppointmentDTO.from(getAppointmentById(appointmentId));
    }

    @Override
    public ResponseUserAppointmentDTO userAppointment(Long userId) {
        return ResponseUserAppointmentDTO.from(getAppointmentsByUserId(userId));
    }

    @Override
    public ResponseCreateAppointmentDTO createAppointment(RequestCreateAppointmentDTO requestCreateAppointmentDTO) {
        appointmentRepository.findByAppointmentDate(requestCreateAppointmentDTO.getDate()).ifPresent(a -> {throw new BaseException(ErrorCode.APPOINTMENT_ALREADY_EXIST);});

        Doctor doctor = doctorService.getDoctorById(requestCreateAppointmentDTO.getDoctorId());
        Appointment appointment = Appointment.builder()
                .user(userService.getUserById(requestCreateAppointmentDTO.getUserId()))
                .doctor(doctor)
                .hospital(doctor.getHospital())
                .appointmentDate(requestCreateAppointmentDTO.getDate())
                .status(AppointmentStatus.RESERVED)
                .build();

        appointmentRepository.save(appointment);

        return ResponseCreateAppointmentDTO.from(appointment);
    }

    @Override
    public ResponseCancelAppointmentDTO cancelAppointment(Long appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment.getStatus() == AppointmentStatus.CANCELED) throw new BaseException(ErrorCode.APPOINTMENT_ALREADY_CANCEL);
        appointment.setStatus(AppointmentStatus.CANCELED);
        appointmentRepository.save(appointment);

        return ResponseCancelAppointmentDTO.from(appointment);
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow(AppointmentNotFound::new);
    }

    public List<Appointment> getAppointmentsByUserId(Long userId) {
        List<Appointment> appointments = appointmentRepository.findByUserId(userId);
        if (appointments.isEmpty()) throw new BaseException(ErrorCode.APPOINTMENT_USER_NOT_FOUND);

        return appointments;
    }
}
