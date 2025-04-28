package hello.hospital.exception;

public class InvalidAccess extends BaseException {

    public InvalidAccess() {
        super(ErrorCode.INVALID_ACCESS);
    }
}
