package com.test.astraia.utils;

import java.util.List;
import java.util.stream.Collectors;

public class FormattingUtils {
    private FormattingUtils() {
    }

    public static String collectionToString(List content, String delimiter) {
        if (content != null) {
            return content.stream().map(Object::toString)
                    .collect(Collectors.joining(delimiter)).toString();
        }
        return "";
    }

    public static String reduceNewLines(String str){
        if(str == null){
            return "";
        }
        return str.replaceAll("\n\n\n|\n\n", "\n");
    }
}
