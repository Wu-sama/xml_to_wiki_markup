package com.test.astraia.model;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class ReportModel {
    private LinkedHashSet<Object> content;

    public LinkedHashSet<Object> getContent() {
        return content;
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

    @Override
    public String toString() {
        return content.stream().map(Object::toString)
                .collect(Collectors.joining(Constants.DELIMITER));
    }
}
