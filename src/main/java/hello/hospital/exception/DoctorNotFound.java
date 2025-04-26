package hello.hospital.exception;

public class DoctorNotFound extends BaseException {

    public DoctorNotFound() {
        super(ErrorCode.DOCTOR_NOT_FOUND);
    }
}
