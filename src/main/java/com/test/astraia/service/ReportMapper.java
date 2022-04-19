package com.test.astraia.service;

import com.test.astraia.model.BoldModel;
import com.test.astraia.model.ItalicModel;
import com.test.astraia.model.ReportModel;
import com.test.astraia.model.SectionModel;
import com.test.astraia.model.xsd.Bold;
import com.test.astraia.model.xsd.Italic;
import com.test.astraia.model.xsd.Report;
import com.test.astraia.model.xsd.Section;

import java.util.ArrayList;
import java.util.List;

public class ReportMapper {
    public ReportModel mapToModel(Report report) {
        ReportModel result = new ReportModel();
        result.setContent(getContent(1, report.getContent()));
        return result;
    }

    private List<Object> getContent(int order, List<Object> content) {
        List<Object> result = new ArrayList<>();
        for (Object element : content) {
            Object model = mapToModel(order, element);
            if (model != null) {
                result.add(model);
            }
        }
        return result;
    }

    private Object mapToModel(int order, Object obj) {
        if (obj instanceof String) {
            return obj.toString().replaceAll("([\\r\\n\\t])", "");
        } else if (obj instanceof Section) {
            return getSectionModel(order, (Section) obj);
        } else if (obj instanceof Italic) {
            return getItalicModel(order, (Italic) obj);
        } else if (obj instanceof Bold) {
            return getBoldModel(order, (Bold) obj);
        }
        return null;
    }

    private BoldModel getBoldModel(int order, Bold bold) {
        BoldModel boldModel = new BoldModel();
        boldModel.setContent(getContent(order, bold.getContent()));
        return boldModel;
    }

    private ItalicModel getItalicModel(int order, Italic italic) {
        ItalicModel italicModel = new ItalicModel();
        italicModel.setContent(getContent(order, italic.getContent()));
        return italicModel;
    }

    private SectionModel getSectionModel(int order, Section section) {
        SectionModel result = new SectionModel();
        result.setHeading(order, section.getHeading());
        result.setContent(getContent(order++, section.getContent()));
        return result;
    }
}
