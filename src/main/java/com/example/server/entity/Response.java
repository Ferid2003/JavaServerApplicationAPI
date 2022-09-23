package com.example.server.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {

    protected LocalDate time;
    protected String message;
    protected Map<?,?> map;
    protected HttpStatus status;
    protected Integer statusCode;
    protected String devMessage;

}
