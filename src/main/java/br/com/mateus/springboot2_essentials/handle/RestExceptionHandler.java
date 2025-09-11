package br.com.mateus.springboot2_essentials.handle;

import br.com.mateus.springboot2_essentials.exception.BadRequestException;
import br.com.mateus.springboot2_essentials.exception.BadRequestExceptionDetails;
import br.com.mateus.springboot2_essentials.exception.ValidationExceptionDetails;
import br.com.mateus.springboot2_essentials.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestExceptionDetails(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(new DateUtil().formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()))
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(new DateUtil().formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()))
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Invalid fields")
                        .details(exception.getMessage())
                        .developerMessage(exception.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
