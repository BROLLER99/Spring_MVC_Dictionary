package com.exeption;

public class SearchException extends CustomException{
    private final static String SEARCH_EXCEPTION = "Ошибка поиска элемента ";
    public SearchException(String message) {
        super(SEARCH_EXCEPTION + message);
    }
}
