package hello.hospital.exception;

public class AppointmentNotFound extends BaseException {

    public AppointmentNotFound() {
        super(ErrorCode.APPOINTMENT_NOT_FOUND);
    }
}
