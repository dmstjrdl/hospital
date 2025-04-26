package hello.hospital.exception;

public class HospitalNotFound extends BaseException {

    public HospitalNotFound() {
        super(ErrorCode.HOSPITAL_NOT_FOUND);
    }
}
