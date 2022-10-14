package com.exeption;

public class DeleteExeption extends CustomException{
    private final static String DELETE_EXCEPTION = "Ошибка удаления элемента ";
    public DeleteExeption(String message) {
        super(DELETE_EXCEPTION + message);
    }
}
