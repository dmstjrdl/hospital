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

    /*
        예약번호 조회
     */
    @GetMapping("/{appointmentId}")
    public ResponseEntity<ResponseInfoAppointmentDTO> infoAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.infoAppointment(appointmentId));
    }

    /*
        사용자 예약 조회
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseUserAppointmentDTO> userAppointment(@PathVariable Long userId) {
        return ResponseEntity.ok(appointmentService.userAppointment(userId));
    }

    /*
        예약 생성
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseCreateAppointmentDTO> createAppointment(@Validated @RequestBody RequestCreateAppointmentDTO requestCreateAppointmentDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(requestCreateAppointmentDTO));
    }

    /*
        예약 취소
     */
    @DeleteMapping("/{appointmentId}/cancel")
    public ResponseEntity<ResponseCancelAppointmentDTO> cancelAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
    }
}
