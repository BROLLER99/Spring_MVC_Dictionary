package com.utils;

import com.exeption.CustomException;
import com.exeption.SplitException;

import java.util.regex.PatternSyntaxException;

public final class FileUtils {
    public static final String SEPARATOR = ":";
    public static final int ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 0;
    public static final int ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 1;
    public static final int TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 2;
    public static final int THREE_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 3;

    public static String toFileEntry(Object... values) {//todo Можно тут конвертор оставить? Или у каждого DAO свой реалзовать.
        StringBuilder stringBuilder = new StringBuilder();
        for (Object value : values) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(SEPARATOR);
            }
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }

    public static String selectionOfIdInLine(String line, int numberOfPart) throws CustomException {//todo Как-то так
        try {
            String[] parts = line.split(SEPARATOR);
            return parts[numberOfPart].trim();
        } catch (PatternSyntaxException e) {
            throw new SplitException(line);
        }
    }
}
