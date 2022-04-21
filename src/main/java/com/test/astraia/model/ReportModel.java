package com.test.astraia.model;

import java.util.ArrayList;
import java.util.List;

import static com.test.astraia.utils.FormattingUtils.collectionToString;

public class ReportModel {
    private List<Object> content;

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return collectionToString(content, Constants.LINE_DELIMITER).replaceAll("\n\n\n|\n\n", "\n");
    }
}
