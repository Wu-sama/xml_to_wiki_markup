package com.test.wiki.markup.model;

import java.util.ArrayList;
import java.util.List;

import static com.test.wiki.markup.utils.FormattingUtils.collectionToString;

public class ItalicModel {
    private static final String BRACE_CHARACTER = "''";

    private List<Object> content;

    @Override
    public String toString() {
        return BRACE_CHARACTER + collectionToString(content, "") + BRACE_CHARACTER ;
    }

    public void addContent(Object object) {
        if (content == null) {
            this.content = new ArrayList<>();
        }
        content.add(object);
    }

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }
}
