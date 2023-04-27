package co.edu.poli.taller1.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TareaException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public TareaException(String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
