package hello.hospital.exception;

public class AppointmentUserNotFound extends BaseException {

    public AppointmentUserNotFound() {
        super(ErrorCode.APPOINTMENT_USER_NOT_FOUND);
    }
}
