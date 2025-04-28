package hello.hospital.appointment.service;

import hello.hospital.appointment.domain.Appointment;
import hello.hospital.appointment.dto.*;

public interface AppointmentService {
    ResponseInfoAppointmentDTO infoAppointment(Long userId, Long appointmentId);
    ResponseCreateAppointmentDTO createAppointment(Long userId, RequestCreateAppointmentDTO requestCreateAppointmentDTO);
    ResponseCancelAppointmentDTO cancelAppointment(Long userId, Long appointmentId);
    ResponseUserAppointmentDTO userAppointment(Long userId);

    Appointment getAppointmentById(Long appointmentId);
}
