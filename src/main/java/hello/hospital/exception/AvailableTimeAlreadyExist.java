package hello.hospital.exception;

public class AvailableTimeAlreadyExist extends BaseException {

    public AvailableTimeAlreadyExist() {
        super(ErrorCode.AVAILABLE_TIME_ALREADY_EXIST);
    }
}
