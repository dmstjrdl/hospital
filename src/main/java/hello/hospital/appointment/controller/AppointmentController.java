package hello.hospital.appointment.controller;

import hello.hospital.appointment.dto.*;
import hello.hospital.appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/{appointmentId}")
    public ResponseEntity<ResponseInfoAppointmentDTO> infoAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.infoAppointment(appointmentId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseUserAppointmentDTO> userAppointment(@PathVariable Long userId) {
        return ResponseEntity.ok(appointmentService.userAppointment(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseCreateAppointmentDTO> createAppointment(@Validated @RequestBody RequestCreateAppointmentDTO requestCreateAppointmentDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(requestCreateAppointmentDTO));
    }

    @DeleteMapping("/{appointmentId}/cancel")
    public ResponseEntity<ResponseCancelAppointmentDTO> cancelAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
    }
}
