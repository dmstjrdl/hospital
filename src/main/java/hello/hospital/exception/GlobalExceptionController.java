package hello.hospital.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Map<String, Object>> handleBaseException(BaseException e) {
        Map<String, Object> error = new HashMap<>();
        error.put("code", e.getErrorCode().name());
        error.put("message", e.getErrorCode().getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(error);
    }
}
