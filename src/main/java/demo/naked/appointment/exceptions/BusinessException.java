package demo.naked.appointment.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.*;
/**
 * Created by thandomafela on 03/07/15.
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        this(message, new Throwable());
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
    }
}
