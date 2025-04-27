package hello.hospital.medicalrecord.controller;

import hello.hospital.medicalrecord.dto.RequestCreateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.RequestUpdateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.ResponseInfoMedicalRecordDTO;
import hello.hospital.medicalrecord.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseInfoMedicalRecordDTO> updateMedicalRecord(@PathVariable Long medicalRecordId, @RequestBody RequestUpdateMedicalRecordDTO requestUpdateMedicalRecordDTO) {
        return ResponseEntity.ok(medicalRecordService.updateMedicalRecord(medicalRecordId, requestUpdateMedicalRecordDTO));
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<ResponseInfoMedicalRecordDTO> infoMedicalRecord(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(medicalRecordService.infoMedicalRecord(appointmentId));
    }

}
