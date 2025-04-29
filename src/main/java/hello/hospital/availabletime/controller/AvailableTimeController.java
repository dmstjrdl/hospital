package hello.hospital.availabletime.controller;

import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.availabletime.dto.RequestUpdateAvailableTimeDTO;
import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;
import hello.hospital.availabletime.service.AvailableTimeService;
import hello.hospital.user.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/available")
@RequiredArgsConstructor
public class AvailableTimeController {

    private final AvailableTimeService availableTimeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseInfoAvailableTime> createAvailableTime(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody RequestCreateAvailableTimeDTO createAvailableTimeDTO) {
        return ResponseEntity.ok(availableTimeService.createAvailableTime(customUserDetails.getId(), createAvailableTimeDTO));
    }

    @PutMapping("/{doctorId}/update")
    public ResponseEntity<ResponseInfoAvailableTime> updateAvailableTime(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable Long doctorId, @RequestBody RequestUpdateAvailableTimeDTO updateAvailableTimeDTO) {
        return ResponseEntity.ok(availableTimeService.updateAvailableTime(customUserDetails.getId(), doctorId, updateAvailableTimeDTO));
    }
}
