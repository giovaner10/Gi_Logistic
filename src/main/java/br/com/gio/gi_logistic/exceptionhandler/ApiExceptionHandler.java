package br.com.gio.gi_logistic.exceptionhandler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    private MessageSource messageSource;
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {


        List<Exception.Campo> campos = new ArrayList<>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()){

            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Exception.Campo(nome, mensagem));
        }

        Exception exception = Exception.builder()
                .status(status.value())
                .dataHora(LocalDateTime.now())
                .titulo("Um ou mais campos apresentam erro")
                .campos(campos)
                .build();

        return handleExceptionInternal(ex,exception, headers, status, request);
    }



    @ExceptionHandler({IncorrectResultSizeDataAccessException.class})
    public ResponseEntity<Object> handlerNegocio(IncorrectResultSizeDataAccessException ex, WebRequest request){
        Exception exception = Exception.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .dataHora(LocalDateTime.now())
                .titulo(ex.getLocalizedMessage())
                .build();
        return handleExceptionInternal(ex,exception, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }

    @ExceptionHandler({NegocioException.class})
    public ResponseEntity<Object> negocioException(NegocioException ex, WebRequest request){
        Exception exception = Exception.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .dataHora(LocalDateTime.now())
                .titulo(ex.getLocalizedMessage())
                .build();
        return handleExceptionInternal(ex,exception, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }
}
