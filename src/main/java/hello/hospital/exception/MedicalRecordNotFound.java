package hello.hospital.exception;

public class MedicalRecordNotFound extends BaseException {

    public MedicalRecordNotFound() {
        super(ErrorCode.MEDICAL_RECORD_NOT_FOUND);
    }
}
