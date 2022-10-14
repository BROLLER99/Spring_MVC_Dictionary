package com.exeption;

public class SplitException extends CustomException{
    private final static String SPLIT_EXCEPTION = "Ошибка разделения строки ";
    public SplitException(String message) {
        super(SPLIT_EXCEPTION + message);
    }
}
