package com.test.astraia.model;

import java.util.LinkedHashSet;

import static com.test.astraia.FormattingUtils.collectionToString;

public class BoldModel {
    private static String BRACE_CHARACTER = "'''";
    private LinkedHashSet<Object> content;

    @Override
    public String toString() {
        return BRACE_CHARACTER + collectionToString(content);
    }

    public void setContent(LinkedHashSet<Object> content) {
        this.content = content;
    }

    public void addContent(Object object) {
        if (content == null) {
            this.content = new LinkedHashSet<Object>();
        }
        content.add(object);
    }
}
