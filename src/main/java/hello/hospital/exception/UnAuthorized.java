package hello.hospital.exception;

public class UnAuthorized extends BaseException {

    public UnAuthorized() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
