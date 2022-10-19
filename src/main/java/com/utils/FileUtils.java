package com.utils;

import com.exeption.CustomException;
import com.exeption.SplitException;
import com.model.PatternModel;
import com.model.RowModel;

import java.util.regex.PatternSyntaxException;

public final class FileUtils {
    public static final String SEPARATOR = ":";
    private static final int ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 0;
    private static final int ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 1;
    private static final int TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 2;
    private static final int THREE_FOR_FIRST_PART_OF_ROW_IN_SPLIT = 3;

    public static String toFileEntry(Object... values) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object value : values) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(SEPARATOR);
            }
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }

    public static String selectionOfIdInLine(String line) throws CustomException {
        try {
            String[] parts = line.split(SEPARATOR);
            String idOfLine = parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim();
            return idOfLine;
        } catch (PatternSyntaxException e) {
            throw new SplitException(line);
        }
    }

    public static Object convertFromLineToEntity(String line) {
        String[] parts = line.split(SEPARATOR);
        if (parts.length == 3) {//todo не норма
            PatternModel pattern = new PatternModel();
            pattern.setPatternId((parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim()));
            pattern.setPatternName(parts[ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            pattern.setPatternRule(parts[TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            return pattern;
        } else {
            RowModel row = new RowModel();
            row.setIdOfRow(parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            row.setWord(parts[ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            row.setValue(parts[TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            row.setPatternId(parts[THREE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            return row;
        }
    }
}
