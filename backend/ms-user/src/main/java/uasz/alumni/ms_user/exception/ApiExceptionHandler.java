package uasz.alumni.ms_user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uasz.alumni.ms_user.exception.AlumniNotfound;
import uasz.alumni.ms_user.exception.ApiExceptionReponse;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler{

    @ExceptionHandler(value = {AlumniNotfound.class})
    public ResponseEntity<Object> hadlerExceptionAlumn(AlumniNotfound alumniNotfound){
        ApiExceptionReponse apiExceptionResponse = new ApiExceptionReponse(
                alumniNotfound.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return  new ResponseEntity<>(apiExceptionResponse,HttpStatus.NOT_FOUND);
    }

}


