package hello.hospital.exception;

public class AppointmentAlreadyExist extends BaseException {

    public AppointmentAlreadyExist() {
        super(ErrorCode.APPOINTMENT_ALREADY_EXIST);
    }
}
