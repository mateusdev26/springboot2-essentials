package br.com.mateus.springboot2_essentials.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String title;
    protected int status;
    protected String details;
    protected String developerMessage;
    protected String timestamp;
}
