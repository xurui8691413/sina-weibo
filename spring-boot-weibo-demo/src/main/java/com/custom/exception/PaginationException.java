package com.custom.exception;

/**
 * Handle pagination exception
 * @author rxu<xurui8611@126.com>
 */
public class PaginationException extends AppRuntimeException {
    public PaginationException(String message) {
        super(message);
    }
}
