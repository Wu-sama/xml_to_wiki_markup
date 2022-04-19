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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ReportMapper {
    public ReportModel mapToModel(Report report){
        ReportModel result = new ReportModel();
        result.setContent(getContent(report.getContent()));
        return result;
    }

    private ArrayList<Object> getContent(List<Object> content) {
        return content.stream().map(it -> mapToModel(1, it)).collect(Collectors.toCollection( ArrayList::new ));
    }

    // todo to Factory
    private Object mapToModel(int order, Object obj){
        if(obj instanceof String){
            return obj;
        } if (obj instanceof Section){
            Section section = (Section) obj;
            SectionModel result = new SectionModel();
            result.setHeading(order, section.getHeading());
            int newOrder = ++order;// todo variable should be efficient final or final need to rethink that case
            result.setContent(section.getContent().stream().map(it -> mapToModel(newOrder, it)).collect(Collectors.toList()));
            return result;
        } if(obj instanceof Italic){
            Italic italic = (Italic) obj;
            ItalicModel italicModel =  new ItalicModel();
            int oldOrder = order;
            italicModel.setContent(italic.getContent().stream().map(it -> mapToModel(oldOrder, it)).collect(Collectors.toList()));
            return italicModel;
        }if(obj instanceof Bold){
            Bold bold = (Bold) obj;
            BoldModel boldModel =  new BoldModel();
            int oldOrder = order;
            boldModel.setContent(bold.getContent().stream().map(it -> mapToModel(oldOrder, it)).collect(Collectors.toList()));
            return boldModel;
        }
        return null;
    }
}
