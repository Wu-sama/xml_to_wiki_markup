package com.test.astraia;

import com.test.astraia.model.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class FormattingUtils {
    private FormattingUtils() {
    }

    public static String collectionToString(List content) {
        if (content != null) {
            return content.stream().map(Object::toString)
                    .collect(Collectors.joining(Constants.DELIMITER)).toString();
        }
        return "";
    }
}
