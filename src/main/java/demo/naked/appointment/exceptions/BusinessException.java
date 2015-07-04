package demo.naked.appointment.exceptions;

/**
 * Created by thandomafela on 03/07/15.
 */
public class BusinessException extends Exception {

    public BusinessException(String message) {
        this(message, new Throwable());
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
    }
}
