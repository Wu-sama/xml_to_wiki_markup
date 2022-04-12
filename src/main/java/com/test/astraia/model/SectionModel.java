package com.test.astraia.model;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class SectionModel {
    private LinkedHashSet<Object> content;
    private Heading heading;

    public LinkedHashSet<Object> getContent() {
        return content;
    }

    public void setContent(LinkedHashSet<Object> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return heading.toString() + "\n" + content.stream().map(Object::toString)
                .collect(Collectors.joining(Constants.DELIMITER));
    }
}
