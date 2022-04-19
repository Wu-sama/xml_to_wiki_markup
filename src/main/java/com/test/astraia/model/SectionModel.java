package com.test.astraia.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SectionModel {
    private List<Object> content;
    private Heading heading;

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }

    public void addContent(Object object) {
        if (content == null) {
            this.content = new ArrayList<>();
        }
        content.add(object);
    }

    public void setHeading(int order, String heading) {
        this.heading = new Heading(heading, order);
    }

    @Override
    public String toString() {
        return heading.toString() + "\n" + content.stream().map(Object::toString)
                .collect(Collectors.joining(Constants.DELIMITER));
    }
}
