package hello.hospital.appointment.controller;

import hello.hospital.appointment.dto.*;
import hello.hospital.appointment.service.AppointmentService;
import hello.hospital.user.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    /*
        예약번호 조회
     */
    @GetMapping("/{appointmentId}")
    public ResponseEntity<ResponseInfoAppointmentDTO> infoAppointment(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.infoAppointment(customUserDetails.getId(), appointmentId));
    }

    /*
        사용자 예약 조회
     */
    @GetMapping("/user")
    public ResponseEntity<ResponseUserAppointmentDTO> userAppointment(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok(appointmentService.userAppointment(customUserDetails.getId()));
    }

    /*
        예약 생성
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseCreateAppointmentDTO> createAppointment(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody RequestCreateAppointmentDTO requestCreateAppointmentDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(customUserDetails.getId(), requestCreateAppointmentDTO));
    }

    /*
        예약 취소
     */
    @DeleteMapping("/{appointmentId}/cancel")
    public ResponseEntity<ResponseCancelAppointmentDTO> cancelAppointment(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(customUserDetails.getId(), appointmentId));
    }
}
