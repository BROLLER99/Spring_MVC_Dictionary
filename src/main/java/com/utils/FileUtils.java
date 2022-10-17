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
        StringBuilder res = new StringBuilder();
        for (Object value : values) {
            if (res.length() != 0) {
                res.append(SEPARATOR);
            }
            res.append(value);
        }
        return res.toString();
    }

    public static String splitAndPartsString(String line) throws CustomException {
        try {
            String[] parts = line.split(SEPARATOR);
            String nameOfDescription = parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim();
            return nameOfDescription;
        } catch (PatternSyntaxException e) {
            throw new SplitException(line);
        }
    }

    public static Object convertFromStringToEntity(String line) {
        String[] parts = line.split(SEPARATOR);
        if (parts.length == 3) {//todo не норма
            PatternModel pattern = new PatternModel();
            pattern.setIdOfDescription((parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim()));
            pattern.setNameOfDescription(parts[ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
            pattern.setDescription(parts[TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
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
