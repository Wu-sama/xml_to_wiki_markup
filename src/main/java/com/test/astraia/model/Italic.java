package com.test.astraia.model;

import java.util.LinkedHashSet;

import static com.test.astraia.FormattingUtils.collectionToString;

public class Italic {
    private static String BRACE_CHARACTER = "''";

    private LinkedHashSet<Object> content;

    @Override
    public String toString() {
        return BRACE_CHARACTER + collectionToString(content);
    }
}
