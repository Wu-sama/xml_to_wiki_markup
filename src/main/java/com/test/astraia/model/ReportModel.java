package com.test.astraia.model;

import java.util.List;

import static com.test.astraia.utils.FormattingUtils.collectionToString;
import static com.test.astraia.utils.FormattingUtils.reduceNewLines;

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
        String result = reduceNewLines(collectionToString(content, Constants.LINE_DELIMITER));
        if("\n".equals(result.substring(0,1))){
            result =  result.substring(1);
        }
        return result;
    }
}
