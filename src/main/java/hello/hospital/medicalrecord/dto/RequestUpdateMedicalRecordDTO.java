package hello.hospital.medicalrecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestUpdateMedicalRecordDTO {

    private String symptoms;    //  증상
    private String diagnosis;   //  진단
    private String prescription;    //  처방
}
