package hello.hospital.medicalrecord.service;

import hello.hospital.medicalrecord.dto.RequestCreateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.RequestUpdateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.ResponseInfoMedicalRecordDTO;

public interface MedicalRecordService {

    ResponseInfoMedicalRecordDTO createMedicalRecord(RequestCreateMedicalRecordDTO requestCreateMedicalRecordDTO);
    ResponseInfoMedicalRecordDTO updateMedicalRecord(Long userId, Long medicalRecordId, RequestUpdateMedicalRecordDTO requestUpdateMedicalRecordDTO);
    ResponseInfoMedicalRecordDTO infoMedicalRecord(Long appointmentId);
}
