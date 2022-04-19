package com.test.astraia;

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
}
