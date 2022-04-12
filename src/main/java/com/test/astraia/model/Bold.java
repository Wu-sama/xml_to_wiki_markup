package com.test.astraia.model;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Bold {
    private static String BRACE_CHARACTER = "'''";
    private LinkedHashSet<Object> content;

    @Override
    public String toString() {
        return BRACE_CHARACTER + content.stream().map(Object::toString)
                .collect(Collectors.joining(Constants.DELIMITER));
    }
}
