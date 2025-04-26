package hello.hospital.exception;

public class UserNotFound extends BaseException {

    public UserNotFound() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
