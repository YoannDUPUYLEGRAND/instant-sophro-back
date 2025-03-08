package yoanndlg.java_instant_sophro.Exceptions;

import org.springframework.http.HttpStatus;

/**
 * The type Base exception.
 */
public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String code;

    /**
     * Instantiates a new Base exception.
     *
     * @param message the message
     * @param status  the status
     * @param code    the code
     */
    public BaseException(String message, HttpStatus status, String code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }


}
