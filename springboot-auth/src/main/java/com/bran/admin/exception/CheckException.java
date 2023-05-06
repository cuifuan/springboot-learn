package com.bran.admin.exception;

public class CheckException extends RuntimeException{
    public CheckException(String msg, Throwable t) {
        super(msg, t);
    }

    public CheckException(String msg) {
        super(msg);
    }
}
