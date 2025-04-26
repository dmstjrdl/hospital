package hello.hospital.exception;

public class AvailableTimeNotFound extends BaseException {

    public AvailableTimeNotFound() {
        super(ErrorCode.AVAILABLE_TIME_NOT_FOUND);
    }
}
