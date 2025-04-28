package hello.hospital.exception;

public class UserAlreadyExists extends BaseException {

    public UserAlreadyExists() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
