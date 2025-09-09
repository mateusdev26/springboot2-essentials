package br.com.mateus.springboot2_essentials.handle;

import br.com.mateus.springboot2_essentials.exception.BadRequestException;
import br.com.mateus.springboot2_essentials.exception.BadRequestExceptionDetails;
import br.com.mateus.springboot2_essentials.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                        .build(),HttpStatus.BAD_REQUEST
        );
    }
}
