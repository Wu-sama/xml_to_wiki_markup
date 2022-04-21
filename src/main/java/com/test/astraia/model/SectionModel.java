package com.test.astraia.model;

import java.util.List;

public class SectionModel {
    private List<Object> content;
    private Heading heading;

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }

    public void setHeading(int order, String heading) {
        this.heading = new Heading(heading, order);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (heading != null) {
            builder.append(Constants.LINE_DELIMITER);
            builder.append(heading);
            builder.append(Constants.LINE_DELIMITER);
        }
        if (content != null) {
            for (int i = 0; i < content.size(); i++) {
                if (i % 2 == 0) {
                    builder.append(Constants.LINE_DELIMITER);
                }
                builder.append(content.get(i).toString());
            }
        }
        return builder.toString();
    }
}
