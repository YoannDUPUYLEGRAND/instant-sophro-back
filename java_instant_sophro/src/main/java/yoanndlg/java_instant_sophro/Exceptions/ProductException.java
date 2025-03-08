package yoanndlg.java_instant_sophro.Exceptions;

import org.springframework.http.HttpStatus;


    /**
     * The type Product exception.
     */
    public class ProductException extends BaseException {
        /**
         * Instantiates a new Product exception.
         *
         * @param message the message
         * @param status  the status
         * @param code    the code
         */
        public ProductException(String message, HttpStatus status, String code) {
            super(message, status, code);
        }
    }

