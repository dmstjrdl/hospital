package hello.hospital.exception;

public class MedicalRecordAlreadyExist extends BaseException {

    public MedicalRecordAlreadyExist() {
        super(ErrorCode.MEDICAL_RECORD_ALREADY_EXIST);
    }
}
