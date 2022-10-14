package com.exeption;

public class CreateFileException extends CustomException{
    private final static String CREATE_FILE_EXCEPTION = "Ошибка создания файла ";
    public CreateFileException(String message) {
        super(CREATE_FILE_EXCEPTION + message);
    }
}
