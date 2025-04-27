package hello.hospital.exception;

public class DepartmentNotFound extends BaseException {

    public DepartmentNotFound() {
        super(ErrorCode.DEPARTMENT_NOT_FOUND);
    }
}
