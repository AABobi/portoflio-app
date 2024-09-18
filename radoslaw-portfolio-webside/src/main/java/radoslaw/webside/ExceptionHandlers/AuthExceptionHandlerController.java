package radoslaw.webside.ExceptionHandlers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice

public class AuthExceptionHandlerController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(BindException ex) {
        List<String> fieldsWithErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getField)
                .toList();
        return ResponseEntity.badRequest().body(fieldsWithErrors);
    }
}
