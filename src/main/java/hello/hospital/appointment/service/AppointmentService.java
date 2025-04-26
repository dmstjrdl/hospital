package hello.hospital.appointment.service;

import hello.hospital.appointment.dto.*;

public interface AppointmentService {
    ResponseInfoAppointmentDTO infoAppointment(Long appointmentId);
    ResponseCreateAppointmentDTO createAppointment(RequestCreateAppointmentDTO requestCreateAppointmentDTO);
    ResponseCancelAppointmentDTO cancelAppointment(Long appointmentId);
    ResponseUserAppointmentDTO userAppointment(Long userId);
}
