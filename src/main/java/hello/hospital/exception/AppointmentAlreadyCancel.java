package hello.hospital.exception;

public class AppointmentAlreadyCancel extends BaseException {

    public AppointmentAlreadyCancel() {
        super(ErrorCode.APPOINTMENT_ALREADY_CANCEL);
    }
}
