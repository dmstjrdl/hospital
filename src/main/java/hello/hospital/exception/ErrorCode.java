package hello.hospital.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    DOCTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "의사를 찾을 수 없습니다."),
    HOSPITAL_NOT_FOUND(HttpStatus.NOT_FOUND, "병원을 찾을 수 없습니다."),
    DEPARTMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "진료과를 찾을 수 없습니다."),
    AVAILABLE_TIME_NOT_FOUND(HttpStatus.NOT_FOUND, "스케쥴을 찾을 수 없습니다."),
    AVAILABLE_TIME_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "해당 요일에 이미 스케쥴이 존재합니다."),
    APPOINTMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 예약을 찾을 수 없습니다."),
    APPOINTMENT_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자에 대한 예약이 존재하지 않습니다."),
    APPOINTMENT_TIME_NOT_AVAILABLE(HttpStatus.BAD_REQUEST, "진료 시간이 아닙니다."),
    APPOINTMENT_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "해당 시간에 이미 예약이 존재합니다."),
    APPOINTMENT_ALREADY_CANCEL(HttpStatus.BAD_REQUEST, "이미 취소된 예약입니다."),
    MEDICAL_RECORD_NOT_FOUND(HttpStatus.NOT_FOUND, "진료 기록을 찾을 수 없습니다."),
    MEDICAL_RECORD_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 진료 기록이 존재합니다."),;

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
