package hello.hospital.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    DOCTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "의사를 찾을 수 없습니다."),
    HOSPITAL_NOT_FOUND(HttpStatus.NOT_FOUND, "병원을 찾을 수 없습니다."),
    APPOINTMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 예약을 찾을 수 없습니다."),
    APPOINTMENT_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자에 대한 예약이 존재하지 않습니다."),
    APPOINTMENT_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 예약이 존재합니다."),
    APPOINTMENT_ALREADY_CANCEL(HttpStatus.BAD_REQUEST, "이미 취소된 예약입니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
