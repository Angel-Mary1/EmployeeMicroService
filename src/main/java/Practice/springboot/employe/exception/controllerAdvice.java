package Practice.springboot.employe.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class controllerAdvice {

    private final View error;

    public controllerAdvice(View error) {
        this.error = error;
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException e){

        Map<String, String> map = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->{
            map.put(error.getField(), error.getDefaultMessage());
        });
        return map;
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e)
    {
        return new ResponseEntity<String>("There is no such record in database", HttpStatus.BAD_GATEWAY);
    }

}
