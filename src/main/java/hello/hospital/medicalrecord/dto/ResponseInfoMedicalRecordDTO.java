package hello.hospital.medicalrecord.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.hospital.medicalrecord.domain.MedicalRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ResponseInfoMedicalRecordDTO {

    private String username;
    private String hospitalName;
    private String departmentName;
    private String doctorName;
    private String symptoms;
    private String diagnosis;
    private String prescription;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public static ResponseInfoMedicalRecordDTO from(MedicalRecord medicalRecord) {
        return new ResponseInfoMedicalRecordDTO(
                medicalRecord.getAppointment().getUser().getName(),
                medicalRecord.getAppointment().getHospital().getName(),
                medicalRecord.getAppointment().getDoctor().getDepartment().getName(),
                medicalRecord.getAppointment().getDoctor().getUser().getName(),
                medicalRecord.getSymptoms(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getPrescription(),
                medicalRecord.getCreatedAt()
        );
    }
}
