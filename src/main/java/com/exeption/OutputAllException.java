package com.exeption;

public class OutputAllException extends CustomException{
    private final static String OUTPUT_ALL_EXCEPTION = "Ошибка вывода всех элементов ";
    public OutputAllException() {
        super(OUTPUT_ALL_EXCEPTION);
    }
}
