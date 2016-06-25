package com.custom.exception;

/**
 * Handle groovy rest client connection exception
 * @author rxu<xurui8611@126.com>
 */
public class RestClientException extends AppRuntimeException{
    public RestClientException(String message) {
        super(message);
    }

    public RestClientException(String message, Throwable cause) {
        super(message, cause);
    }

}
