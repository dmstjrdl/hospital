package hello.hospital.exception;

public class AppointmentTimeNotAvailable extends BaseException {

    public AppointmentTimeNotAvailable() {
        super(ErrorCode.APPOINTMENT_TIME_NOT_AVAILABLE);
    }
}
