package hello.hospital.medicalrecord.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class RequestCreateMedicalRecordDTO {

    private Long appointmentId;
    private String symptoms;    //  증상
    private String diagnosis;   //  진단
    private String prescription;    //  처방

}
