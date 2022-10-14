package com.exeption;

public class AddException extends CustomException{
    private final static String ADD_EXCEPTION = "Ошибка добавления элемента ";
    public AddException(String message) {

        super(ADD_EXCEPTION + message);
    }
}
