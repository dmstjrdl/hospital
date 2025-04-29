package hello.hospital.medicalrecord.controller;

import hello.hospital.medicalrecord.dto.RequestCreateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.RequestUpdateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.ResponseInfoMedicalRecordDTO;
import hello.hospital.medicalrecord.service.MedicalRecordService;
import hello.hospital.user.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping("/add")
    public ResponseEntity<ResponseInfoMedicalRecordDTO> createMedicalRecord(@RequestBody RequestCreateMedicalRecordDTO requestCreateMedicalRecordDTO) {
        return ResponseEntity.ok(medicalRecordService.createMedicalRecord(requestCreateMedicalRecordDTO));
    }

    @PutMapping("/{medicalRecordId}/update")
    public ResponseEntity<ResponseInfoMedicalRecordDTO> updateMedicalRecord(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable Long medicalRecordId, @RequestBody RequestUpdateMedicalRecordDTO requestUpdateMedicalRecordDTO) {
        return ResponseEntity.ok(medicalRecordService.updateMedicalRecord(customUserDetails.getId(), medicalRecordId, requestUpdateMedicalRecordDTO));
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<ResponseInfoMedicalRecordDTO> infoMedicalRecord(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(medicalRecordService.infoMedicalRecord(appointmentId));
    }

}
