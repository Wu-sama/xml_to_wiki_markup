package com.test.astraia;

import com.test.astraia.model.Constants;

import java.util.Collection;
import java.util.stream.Collectors;

public class FormattingUtils {
    private FormattingUtils(){}

    public static String collectionToString(Collection content){
        return content.stream().map(Object::toString)
                .collect(Collectors.joining(Constants.DELIMITER)).toString();
    }
}
