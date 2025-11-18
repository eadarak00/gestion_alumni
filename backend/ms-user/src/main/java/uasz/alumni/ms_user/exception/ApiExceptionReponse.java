package uasz.alumni.ms_user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiExceptionReponse {
    private String message;
    private HttpStatus status;
    private ZonedDateTime timestamp;
}
