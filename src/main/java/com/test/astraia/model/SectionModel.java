package com.test.astraia.model;

import java.util.ArrayList;
import java.util.List;

import static com.test.astraia.FormattingUtils.collectionToString;

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
        StringBuilder builder = new StringBuilder();
        if (heading != null) {
            builder.append(heading);
            builder.append("\n");
        }
        if (content != null) {
            builder.append(collectionToString(content));
        }
        return builder.toString();
    }
}
