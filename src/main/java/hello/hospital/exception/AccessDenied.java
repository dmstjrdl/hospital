package hello.hospital.exception;

public class AccessDenied extends BaseException {

    public AccessDenied() {
        super(ErrorCode.ACCESS_DENIED);
    }
}
